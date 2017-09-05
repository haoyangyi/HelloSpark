package com.hyy.spark.scala.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 2016/12/2.
  */
object SecondSort {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SecondSortKey").setMaster("local")
    val sc= new SparkContext(conf)
    val pairs=sc.textFile("textdata/sort.txt").map(line=>{
      val lineSplited= line.split("\\s+")
      val key=new SecondSortKey(lineSplited(0).toInt,lineSplited(2).toInt)
      (key,line)
    })

    val sortedPairs= pairs.sortByKey()
    val results=sortedPairs.map((_._2))

    results.foreach(println(_))
  }
}


