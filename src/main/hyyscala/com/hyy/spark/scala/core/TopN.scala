package com.hyy.spark.scala.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 2016/12/1.
  */
object TopN {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("TopN").setMaster("local")
    val sc = new SparkContext(conf)
    val linesRdd=sc.textFile("textdata/top.txt")
    val pairsRdd=linesRdd.map(value=>(Integer.valueOf(value),value))
    val results=pairsRdd.sortByKey(false).map((_._2)).take(3)
    results.foreach(println(_))
  }
}
