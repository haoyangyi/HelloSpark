package com.hyy.spark.scala.oprator

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.api.java.JavaSparkContext

/**
  * Created by root on 2016/12/1.
  */
object CollectOperator {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("ReduceOperator").setMaster("local")
    val sc= new SparkContext(conf)
    val numberList=Array(1, 2, 3, 4, 5)
    val numbers=sc.parallelize(numberList)
    val doubleNumbers=numbers.map((_*2))
    val doubleNumberList=doubleNumbers.collect()
    doubleNumberList.foreach(println(_))
  }
}
