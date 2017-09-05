package com.bjhyy.core

import org.apache.spark.{SparkConf, SparkContext}

object MySparkPi {
  
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("MySparkPi").setMaster("local")
    val sc = new SparkContext(conf)
    
    // PI = 3.1415926...
    val slices = 100
    val n = 1000 * slices
    val count = sc.parallelize(1 to n, slices).map { i =>  
      def random : Double = java.lang.Math.random()
      val x = random * 2 - 1 
      val y = random * 2 - 1
      if(x * x + y * y < 1) 1 else 0 
    }.reduce(_+_)
    
    println("Pi is " + 4.0 * count / n)
    sc.stop()
  }
  
}