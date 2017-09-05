package cn.itcast.spark.day1

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 2016/11/28.
  */
object HyyWordCount {
  def main(args: Array[String]) {
    println("hello")
    val conf=new SparkConf().setAppName("hyy-wordcount").setMaster("local[1]")
    val sc=new SparkContext(conf)
    val rdd=sc.textFile("wordcount.txt").flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).sortBy(_._2,false)
    rdd.foreach(e=>println(e._2))
    rdd.foreach(println(_))
//    val list=rdd.collect()
//    list.foreach(println(_))
  }
}
