package com.hyy.spark.scala.oprator

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by root on 2016/12/1.
  */
object CartesianOperator {
  def main(args: Array[String]) {
    val conf=new SparkConf().setAppName("CartesianOperator").setMaster("local")
    val sc=new SparkContext(conf)
    val clothes=Array("T恤衫", "夹克", "皮大衣", "衬衫", "毛衣")
    val trousers=Array("西裤", "内裤", "铅笔裤", "皮裤", "牛仔裤")
    val clothesRDD=sc.parallelize(clothes)
    val trousersRDD = sc.parallelize(trousers)

    val pairs=clothesRDD.cartesian(trousersRDD)
    pairs.foreach(println(_))
  }
}
