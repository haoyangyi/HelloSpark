package com.hyy.spark.scala.oprator

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 2016/12/1.
  */
object CountOperator {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("ReduceOperator").setMaster("local")
    val sc= new SparkContext(conf)
    val numberList=List(1, 2, 3, 4, 5)
    val numbers= sc.parallelize(numberList)
    val count = numbers.count
    println(count)
  }
}
