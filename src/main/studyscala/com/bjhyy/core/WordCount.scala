package com.bjhyy.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yasaka on 2016/6/2.
  */
object WordCount {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("WordCount").setMaster("local")
    val sc = new SparkContext(conf)

    // RDD 分布式弹性数据集
    val text = sc.textFile("CHANGES.txt")
    // flatMap = map + flat
    val words = text.flatMap(_.split(" "))
    val pairs = words.map((_,1))
    // reduceByKey = reduce + groupByKey
    val results = pairs.reduceByKey(_+_)
    results.foreach(println(_))
  }
}
