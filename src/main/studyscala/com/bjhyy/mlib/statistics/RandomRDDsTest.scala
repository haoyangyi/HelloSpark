package com.bjhyy.mlib.statistics

import org.apache.log4j.{Level, Logger}
import org.apache.spark.mllib.random.RandomRDDs
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 2016/12/6.
  */

//随机数生成
//随机生成的数，符合正态分布
object RandomRDDsTest {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    val sc = new SparkContext(new SparkConf().setAppName("testRandomRDDs").setMaster("local"))
    val u = RandomRDDs.normalRDD(sc, 100000L, 10)
    u.foreach(println(_))
  }
}
