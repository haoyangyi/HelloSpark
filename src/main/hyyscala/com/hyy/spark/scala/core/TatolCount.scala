package com.hyy.spark.scala.core

import org.apache.spark.{SparkConf, SparkContext}

object TatolCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("total")
    val sc = new SparkContext(conf)
    val text = sc.textFile("textdata/total.txt")

    //求总数
    val intRdd=text.map(_.toInt)
    val result=intRdd.reduce(_+_)

    println(result)
    sc.stop()
    println("asdasdasd")
  }
}