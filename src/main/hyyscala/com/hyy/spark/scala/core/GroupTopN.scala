package com.hyy.spark.scala.core

import java.util
import java.util.{Comparator, Collections, ArrayList}

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.api.java.JavaSparkContext

/**
  * Created by root on 2016/12/2.
  */
object GroupTopN {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("GroupTopN").setMaster("local")
    val sc = new SparkContext(conf)

    val linesRdd=sc.textFile("textdata/score.txt")
    val pairsRdd=linesRdd.map (line=>{
      val arr=line.split(" ")
      (arr(0), Integer.valueOf(arr(1)))
    })
   val top2score=pairsRdd.groupByKey().map(tuple=>{
      var list:util.List[Integer]=new ArrayList[Integer]
      val scores=tuple._2
      val it = scores.iterator
     while(it.hasNext){
       val score=it.next()
       list.add(score)
     }

     Collections.sort(list,new Comparator[Integer] {
       override def compare(o1: Integer, o2: Integer): Int = -(o1-o2)
     })
     list=list.subList(0,2)
     (tuple._1, list)
   })

    top2score.foreach(tuple=>{
      println(" city : " + tuple._1)
      val scores = tuple._2.iterator()
      while(scores.hasNext){
        println(scores.next())
      }
      println("========================11")
    })
  }
}
