package com.bjhyy.mlib.statistics

import org.apache.log4j.{Level, Logger}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 2016/12/6.
  */
object Corr {
  def main(args: Array[String]) {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    val sc = new SparkContext(new SparkConf().setAppName("testCorr").setMaster("local"))
    val data: RDD[Array[Double]] = sc.parallelize(Array(Array[Double](12,3,4,5),Array[Double](67,1,5,9),Array[Double](35,6,3,1),Array[Double](31,1,5,6)))
    val vdata= data.map(sample=>Vectors.dense(sample))
    
    val corr1 = Statistics.corr(vdata,"pearson")
    val corr2 = Statistics.corr(vdata,"spearman")
    val x1 = sc.parallelize(Array(1.0,2.0,3.0,4.0))
    val x2 = sc.parallelize(Array(5.0,6.0,6.0,6.0))
    val corr3 = Statistics.corr(x1,x2,"pearson")
    println(corr1)
    println(corr2)
    println("*"*100)
    println(corr3)
  }
}
