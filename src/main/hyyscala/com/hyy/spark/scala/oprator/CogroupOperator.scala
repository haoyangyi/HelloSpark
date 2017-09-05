package com.hyy.spark.scala.oprator

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by root on 2016/12/1.
  */
object CogroupOperator {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("ReduceOperator").setMaster("local")
    val sc = new SparkContext(conf)

    val studentsList=Array(("1", "xuruyun"), ("2", "wangfei"), ("3", "lixin"))
    val scoreList=Array(("1", "100"), ("2", "90"), ("3", "80"), ("1", "70"), ("2", "60"), ("3", "50"))
    var students= sc.parallelize(studentsList)
    var scores= sc.parallelize(scoreList)
    var studentScores= students.cogroup(scores)
    studentScores.foreach((tuple)=>{
      println(tuple._1+":"+tuple._2._1.toList+":"+tuple._2._2.toList)
    })
  }
}
