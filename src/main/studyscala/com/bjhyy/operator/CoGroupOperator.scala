package com.bjhyy.operator

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by root on 2016/11/29.
  */
object CoGroupOperator {

  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName("CoGroupOperator")
    val sc = new SparkContext(conf)

    val nameList = Array((1,"xuruyun"),(2,"liangyongqi"),(3,"wangfei"))
    val scoreList = Array((1,100),(2,90),(3,80),(3,70))

    val nameRDD = sc.parallelize(nameList)
    val scoreRDD = sc.parallelize(scoreList)

    val results = nameRDD.cogroup(scoreRDD)
    results.foreach(println(_))
  }
}
