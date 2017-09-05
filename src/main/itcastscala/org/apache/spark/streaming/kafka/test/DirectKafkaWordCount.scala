package org.apache.spark.streaming.kafka.test

import com.bjhyy.sql.Student
import kafka.serializer.StringDecoder
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.streaming.kafka.KafkaManager
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * 基于spark streaming direct模式
  * 偏移量维护于zookeeper，方便kafka集群工具监控
  */
object DirectKafkaWordCount {

  /*  def dealLine(line: String): String = {
      val list = line.split(',').toList
  //    val list = AnalysisUtil.dealString(line, ',', '"')// 把dealString函数当做split即可
      list.get(0).substring(0, 10) + "-" + list.get(26)
    }*/

  def processRdd(rdd: RDD[(String, String)]): Unit = {
    val lines = rdd.map(_._2)
    val words = lines.flatMap(_.split(" "))
    val wordCounts = words.map(x => (x, 1L)).reduceByKey(_ + _)
    wordCounts.foreach(println)


    val data=lines.map(lines=>{
      val arr=lines.split("\\|")
      println(lines)
      SzSendBuf(arr(0),
        arr(1),
        arr(2),
        arr(3),
        arr(4),
        arr(5),
        arr(6),
        arr(7),
        arr(8),
        arr(9))
    })
    //        import sqlContext.implicits._
    //        data.toDF()

    val sqlContext = new SQLContext(rdd.context)
    val df=sqlContext.createDataFrame(data)
    println(df.schema)
    df.show()

    //        studentDF.registerTempTable("students")
    //        val teenagerDF = sqlContext.sql("select * from students where age <= 18")
    //        val teenagerRDD = teenagerDF.rdd
    //
    //        // 这个scala版本比java的版本呢要亲和一点,没有像JAVA一样按照字典排序,而是保证了我们的这个顺序！
    //        teenagerDF.map(row => Student(row(0).toString.toInt, row(1).toString, row(2).toString.toInt))
    //          .collect().foreach(stu => println(stu.id + ":" + stu.name + ":" + stu.age))
    //
    //        // 首先scala中保证了顺序的一致,见上面,其次scala中对这个row的使用,比java的row使用更丰富
    //        teenagerRDD.map(row => Student(row.getAs[Int]("id"), row.getAs[String]("name"), row.getAs[Int]("age")))
    //          .collect().foreach(stu => println(stu.id + ":" + stu.name + ":" + stu.age))
    //
    //        teenagerRDD.map(row => {
    //          val map = row.getValuesMap[Any](Array("id","name","age"))
    //          Student(map("id").toString.toInt, map("name").toString, map("age").toString.toInt)
    //        }).collect().foreach(stu => println(stu.id + ":" + stu.name + ":" + stu.age))
    //      }
  }

  def main(args: Array[String]) {
    if (args.length < 3) {
      System.err.println(
        s"""
           |Usage: DirectKafkaWordCount <brokers> <topics> <groupid>
           |  <brokers> is a list of one or more Kafka brokers
           |  <topics> is a list of one or more kafka topics to consume from
           |  <groupid> is a consume group
           |
        """.stripMargin)
      System.exit(1)
    }

    Logger.getLogger("org").setLevel(Level.WARN)

    val Array(brokers, topics, groupId) = args

    // Create context with 2 second batch interval
    val sparkConf = new SparkConf().setAppName("DirectKafkaWordCount")
    sparkConf.setMaster("local[*]")
    sparkConf.set("spark.streaming.kafka.maxRatePerPartition", "5")
    sparkConf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")

    val ssc = new StreamingContext(sparkConf, Seconds(2))

    // Create direct kafka stream with brokers and topics
    val topicsSet = topics.split(",").toSet
    val kafkaParams = Map[String, String](
      "metadata.broker.list" -> brokers,
      "group.id" -> groupId,
      "auto.offset.reset" -> "smallest"
    )

    val km = new KafkaManager(kafkaParams)

    val messages = km.createDirectStream[String, String, StringDecoder, StringDecoder](
      ssc, kafkaParams, topicsSet)

    messages.foreachRDD(rdd => {
      if (!rdd.isEmpty()) {
        // 先处理消息
        processRdd(rdd)
        // 再更新offsets
        km.updateZKOffsets(rdd)
      }
    })

    ssc.start()
    ssc.awaitTermination()
  }

    case class SzSendBuf(nEventType:String,
                         nTime:String,
                         dwCaster:String,
                         dwTarget:String,
                         nEffectType:String,
                         dwEffectID:String,
                         dwEffectLevel:String,
                         szEffectName:String,
                         nValue:String,
                         nEffectValue:String
                        )
}

