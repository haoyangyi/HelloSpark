package com.hyy.recommender.test

import java.io.PrintWriter

import org.apache.spark.mllib.linalg.SparseVector
import org.apache.spark.mllib.regression.{LinearRegressionWithSGD, LabeledPoint}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkContext, SparkConf}
import scala.collection.Map
/**
  * Created by root on 2016/12/8.
  */
object Recommender {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Recommender").setMaster("local")
    val sc = new SparkContext(conf)
    val data:RDD[Array[String]]=sc.textFile("textdata1/000000_0").map(_.split("\t"))
    val dict:Map[String,Long]=data.flatMap(_(1).split(";")).map(_.split(":")(0)).distinct().zipWithIndex().collectAsMap()
//    val dict: Map[String, Long] =  data.flatMap(_(1).split(";")).map(_.split(":")(0)).distinct().zipWithIndex().collectAsMap()
    val realData=data.map(sample=>{
      val label=sample(0) match {
        case "-1"=>0.0
        case _=>1.0
      }

      val indexs=sample(1).split(";").map(_.split(":")(0)).map(feature=>{
        val index:Long=dict.getOrElse(feature,-1L)
        index.toInt
      })

      new LabeledPoint(label,new SparseVector(dict.size,indexs,Array.fill(indexs.length)(1.0)))
    })

    val model = LinearRegressionWithSGD.train(realData, 30, 0.8)
    val weights=model.weights.toArray
    val map:Map[Long,String]=dict.map(x=>(x._2,x._1))
    val pt=new PrintWriter("textdata1/out")
    for(i<-0 until weights.length){
      val res=map.getOrElse(i,"")+"\t"+weights(i)
      pt.write(res)
      pt.println()
      println(res)
    }
    pt.flush()
    pt.close()
  }
}
