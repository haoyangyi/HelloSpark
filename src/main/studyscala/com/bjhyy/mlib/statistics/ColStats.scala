package com.bjhyy.mlib.statistics

import org.apache.log4j.{Level, Logger}
import org.apache.spark.mllib.linalg.{Vectors, Vector}
import org.apache.spark.mllib.stat.{Statistics, MultivariateStatisticalSummary}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by root on 2016/12/6.
  */
object ColStats {
  def main(args: Array[String]) {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    val sc = new SparkContext(new SparkConf().setAppName("testColStats").setMaster("local"))
    val data: RDD[Array[Double]] = sc.parallelize(Array(Array[Double](12,3,4,5),Array[Double](67,1,5,9),Array[Double](35,6,3,1),Array[Double](31,1,5,6)))
    val vdata= data.map(sample=>Vectors.dense(sample))
    val stat = Statistics.colStats(vdata)
    println(stat.max) //最大值
    println(stat.min) //最小值
    println(stat.mean) //平均值
    println(stat.variance) //方差值
    println(stat.normL1) //L1范数
    println(stat.normL2) //L2范数
  }
}
