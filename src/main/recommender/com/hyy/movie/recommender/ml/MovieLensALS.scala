/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off println
package com.hyy.movie.recommender.ml

import com.hyy.movie.recommender.AbstractParams
import org.apache.spark.ml.recommendation.ALS
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
 * An example app for ALS on MovieLens data (http://grouplens.org/datasets/movielens/).
 * Run with
 * {{{
 * bin/run-example ml.MovieLensALS
 * }}}
 */
object MovieLensALS {

  case class Rating(userId: Int, movieId: Int, rating: Float, timestamp: Long)

  object Rating {
    def parseRating(str: String): Rating = {
      val fields = str.split("::")
      assert(fields.size == 4)
      Rating(fields(0).toInt, fields(1).toInt, fields(2).toFloat, fields(3).toLong)
    }
  }

  case class Movie(movieId: Int, title: String, genres: Seq[String])

  object Movie {
    def parseMovie(str: String): Movie = {
      val fields = str.split("::")
      assert(fields.size == 3)
      Movie(fields(0).toInt, fields(1), fields(2).split("\\|"))
    }
  }

  case class Params(
      ratings: String = "textdata/movie/sample_movielens_ratings.txt",
      movies: String = "textdata/movie/sample_movielens_movies.txt",
      maxIter: Int = 5,
      regParam: Double = 0.1,
      rank: Int = 10,
      numBlocks: Int = 10) extends AbstractParams[Params]

  def main(args: Array[String]) {
    //          | bin/spark-submit --class org.apache.spark.examples.ml.MovieLensALS \
    //          |  examples/target/scala-*/spark-examples-*.jar \
    //          |  --rank 10 --maxIter 15 --regParam 0.1 \
    //          |  --movies data/mllib/als/sample_movielens_movies.txt \
    //          |  --ratings data/mllib/als/sample_movielens_ratings.txt
    val defaultParams = Params()
    run(defaultParams)
//
//    val parser = new OptionParser[Params]("MovieLensALS") {
//      head("MovieLensALS: an example app for ALS on MovieLens data.")
//      opt[String]("ratings")
//        .required()
//        .text("path to a MovieLens dataset of ratings")
//        .action((x, c) => c.copy(ratings = x))
//      opt[String]("movies")
//        .required()
//        .text("path to a MovieLens dataset of movies")
//        .action((x, c) => c.copy(movies = x))
//      opt[Int]("rank")
//        .text(s"rank, default: ${defaultParams.rank}")
//        .action((x, c) => c.copy(rank = x))
//      opt[Int]("maxIter")
//        .text(s"max number of iterations, default: ${defaultParams.maxIter}")
//        .action((x, c) => c.copy(maxIter = x))
//      opt[Double]("regParam")
//        .text(s"regularization parameter, default: ${defaultParams.regParam}")
//        .action((x, c) => c.copy(regParam = x))
//      opt[Int]("numBlocks")
//        .text(s"number of blocks, default: ${defaultParams.numBlocks}")
//        .action((x, c) => c.copy(numBlocks = x))
//      note(
//        """
//          |Example command line to run this app:
//          |
//          | bin/spark-submit --class org.apache.spark.examples.ml.MovieLensALS \
//          |  examples/target/scala-*/spark-examples-*.jar \
//          |  --rank 10 --maxIter 15 --regParam 0.1 \
//          |  --movies data/mllib/als/sample_movielens_movies.txt \
//          |  --ratings data/mllib/als/sample_movielens_ratings.txt
//        """.stripMargin)
//    }
//
//    parser.parse(args, defaultParams).map { params =>
//      run(params)
//    } getOrElse {
//      System.exit(1)
//    }
  }

  def run(params: Params) {
    //设置为本地模式测试
    val conf = new SparkConf().setAppName(s"MovieLensALS with $params").setMaster("local")
    val sc = new SparkContext(conf)
    //创建SparkSql
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    //读取用户电影评论信息并缓存
    val ratings = sc.textFile(params.ratings).map(Rating.parseRating).cache()

    //获取用户电影评论总条数
    val numRatings = ratings.count()
    //根据电影评论去重获取用户数量
    val numUsers = ratings.map(_.userId).distinct().count()
    //根据电影评论去重获取用电影数量
    val numMovies = ratings.map(_.movieId).distinct().count()

    // Got 1501 ratings from 30 users on 100 movies.
    println(s"Got $numRatings ratings from $numUsers users on $numMovies movies.")

    //将评论数据随机切分为0.8(训练数据)和0.2(测试数据),并缓存
    val splits = ratings.randomSplit(Array(0.8, 0.2), 0L)
    val training = splits(0).cache()
    val test = splits(1).cache()
    //数量数据和测试数据数目
    val numTraining = training.count()
    val numTest = test.count()

    //Training: 1199, test: 302.
    println(s"Training: $numTraining, test: $numTest.")

    //清除电影评论rdd的数据(非阻塞)
    ratings.unpersist(blocking = false)

    //Alternating Least Squares
    //ALS参数初始化
    val als = new ALS()
      .setUserCol("userId")
      .setItemCol("movieId")
      .setRank(params.rank)
      .setMaxIter(params.maxIter)
      .setRegParam(params.regParam)
      .setNumBlocks(params.numBlocks)
    //训练数据训练模型，返回dateframe
    val model = als.fit(training.toDF())
    //测试数据预测模型，返回dateframe
    val predictions = model.transform(test.toDF()).cache()

    // Evaluate the model.
    //模型评估
    // TODO: Create an evaluator to compute RMSE.

    //MSE: Mean Squared Error
    //均方误差是指参数估计值与参数真值之差平方的期望值;
    //MSE可以评价数据的变化程度，MSE的值越小，说明预测模型描述实验数据具有更好的精确度。
    val mse = predictions.select("rating", "prediction").rdd
      .flatMap { case Row(rating: Float, prediction: Float) =>
        val err = rating.toDouble - prediction
        val err2 = err * err
        if (err2.isNaN) {
          None
        } else {
          Some(err2)
        }
      }.mean()

    //RMSE
    //均方误差:均方根误差是均方误差的算术平方根
    val rmse = math.sqrt(mse)
    println(s"Test RMSE = $rmse.")

    // Inspect false positives.
    // Note: We reference columns in 2 ways:
    //  (1) predictions("movieId") lets us specify the movieId column in the predictions
    //      DataFrame, rather than the movieId column in the movies DataFrame.
    //  (2) $"userId" specifies the userId column in the predictions DataFrame.
    //      We could also write predictions("userId") but do not have to since
    //      the movies DataFrame does not have a column "userId."
    //加载电影数据
    val movies = sc.textFile(params.movies).map(Movie.parseMovie).toDF()

//    +------+-------+------+----------+-----------+
//    |userId|movieId|rating| timestamp| prediction|
//    +------+-------+------+----------+-----------+
//    |     4|     31|   1.0|1424380312|  1.5380094|
//      |     5|     31|   1.0|1424380312|   1.592255|
//      |    18|     31|   1.0|1424380312| 0.33302903|
//      |    29|     31|   1.0|1424380312|  1.8967779|
    predictions.show(30)

//    +-------+--------+-------------------+
//    |movieId|   title|             genres|
//    +-------+--------+-------------------+
//    |      0| Movie 0|  [Romance, Comedy]|
//    |      1| Movie 1|    [Action, Anime]|
//    |      2| Movie 2|[Romance, Thriller]|
    movies.show(30)

    val falsePositives = predictions.join(movies)
      .where((predictions("movieId") === movies("movieId"))
        && ($"rating" <= 1) && ($"prediction" >= 4))
      .select($"userId", predictions("movieId"), $"title", $"rating", $"prediction")
    val numFalsePositives = falsePositives.count()
    println(s"Found $numFalsePositives false positives")
    if (numFalsePositives > 0) {
      println(s"Example false positives:")
      falsePositives.limit(100).collect().foreach(println)
    }

    sc.stop()
  }
}
// scalastyle:on println
