package com.bjhyy.sql

import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 2016/8/8.
  */
object UDF {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("UDF").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    val names = Array("Yasaka", "Xuruyun", "Wangfei", "Liangyongqi")
    val namesRDD = sc.parallelize(names, 4)
    val namesRowRDD = namesRDD.map(name=>Row(name))
    val structType = StructType(Array(StructField("name",StringType,true)))
    val namesDF = sqlContext.createDataFrame(namesRowRDD, structType)

    namesDF.registerTempTable("names")

    sqlContext.udf.register("strLength", (str: String) => str.length + 10)

    sqlContext.sql("select name, strLength(name) from names")
      .collect().foreach(println)
  }
}
