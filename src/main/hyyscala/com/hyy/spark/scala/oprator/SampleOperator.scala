package com.hyy.spark.scala.oprator

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 2016/12/1.
  */
object SampleOperator {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SampleOperator").setMaster("local")
    val sc = new SparkContext(conf)
    val names=List("xurunyun", "liangyongqi", "wangfei", "yasaka", "xurunyun", "liangyongqi", "wangfei", "yasaka1")
    val nameRDD= sc.parallelize(names, 2)
    nameRDD.sample(false, 0.33).foreach(println(_))
  }
}
