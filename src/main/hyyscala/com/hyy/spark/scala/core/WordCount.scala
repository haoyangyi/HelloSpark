package com.hyy.spark.scala.core

import org.apache.spark.{SparkConf, SparkContext}
object WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("wc")
//    conf.set("spark.default.parallelism","5");
    val sc = new SparkContext(conf)
    
    val text = sc.textFile("textdata/wordcount.txt")
    val words = text.flatMap {_.split(" ") }

    val pairs = words.map { word => (word, 1) }
    val pairs1=words.map{
      word=>{
        (word, 1)
      }
    }
    val pairs2=pairs.map{
      word=>(word._1,1)
    }
//    val results = pairs.countByKey();
    val results = pairs.reduceByKey(_+_)


//    val sorted = results.sortBy(_._2,false);

    val temp1=results.map(word=>(word._2,word._1))
    val temp1sorted = temp1.sortByKey(false)
    val sorted=temp1sorted.map(word=>(word._2,word._1))
    sorted.foreach { println(_) }
    sc.stop()
    println("asdasdasd")
  }

}