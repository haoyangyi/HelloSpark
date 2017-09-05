package com.hyy.spark.scala.oprator

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by root on 2016/12/1.
  */
object CoalesceOperator {
  def main(args: Array[String]) {
    val conf=new SparkConf().setAppName("CoalesceOperator").setMaster("local")
    val sc=new SparkContext(conf)
    val staffList=List("xuruyun1", "xuruyun2", "xuruyun3", "xuruyun4", "xuruyun5", "xuruyun6"
      , "xuruyun7", "xuruyun8", "xuruyun9", "xuruyun10", "xuruyun11", "xuruyun12")
    val staffRDD = sc.parallelize(staffList, 6)
    val staffRDD2=staffRDD.mapPartitionsWithIndex(
        (index,iter)=>{
          var result=List[String]()
          while(iter.hasNext){
            val staff=iter.next()

            result=result.::("部门[" + (index + 1) + "]" + staff)
//            result.::("部门[" + (index + 1) + "]" + staff)
          }
          result.iterator
        },true)

    staffRDD2.collect().foreach(println(_))

    val staffRDD3 = staffRDD2.coalesce(3);

    val staffRDD4=staffRDD3.mapPartitionsWithIndex(
      (index,iter)=>{
        var result=List[String]()
        while(iter.hasNext){
          val staff=iter.next()
          result=result.::("部门[" + (index + 1) + "]" + staff)
        }
        result.iterator
      },true)

    staffRDD4.collect().foreach(println(_))

  }
}
