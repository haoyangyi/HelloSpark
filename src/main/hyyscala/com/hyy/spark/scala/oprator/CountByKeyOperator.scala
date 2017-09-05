package com.hyy.spark.scala.oprator

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by root on 2016/12/1.
  */
object CountByKeyOperator {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("CountByKeyOperator").setMaster("local[3]")
    val sc = new SparkContext(conf)
    val scoreList=Array(("70s", "xuruyun"), ("70s", "wangfei"), ("70s", "wangfei"),
      ("80s", "yasaka"), ("80s", "zhengzongwu"), ("80s", "lixin"))
    val students=sc.parallelize(scoreList)
    val counts=students.countByKey()
    counts.keys.foreach(key=>(println(key+":"+counts.get(key))))

//    counts.keys.foreach{
//      key=>
//        println(key+":"+counts.get(key))
//    }

  }
}
