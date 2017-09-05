package com.hyy.spark.scala.oprator

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by root on 2016/12/1.
  */
object AggregateByKeyOperator {
  def main(args: Array[String]) {
    val conf=new SparkConf().setAppName("AggregateByKeyOperator").setMaster("local")
    val sc=new SparkContext(conf)
    val lines=sc.textFile("textdata/wordcount.txt");
    val wordCounts=lines.flatMap(_.split(" ")).map((_,1)).aggregateByKey(0)((_+_),(_+_))
    var list=wordCounts.collect();
    list.foreach(println(_));
  }
}
