package com.bjhyy.mlib.statistics

import org.apache.spark.mllib.linalg.{Matrices, Vectors}
import org.apache.spark.mllib.stat.Statistics

/**
  * Created by root on 2016/12/6.
  */
object ChiSqTest {
  def main(args: Array[String]): Unit = {
    val v1 = Vectors.dense(43.0,9.0)
    val v2 = Vectors.dense(44.0,4.0)
    val c1 = Statistics.chiSqTest(v1,v2)
    println(c1)
    println("#"*100)
    val mtx = Matrices.dense(3, 2, Array(1, 3, 5, 2, 4, 6))
    val mtxResult = Statistics.chiSqTest(mtx)
    println(mtx)
    //方法、自由度、方法的统计量、 p值 和公式有关
    println(mtxResult)
  }
}
