package com.bjhyy.sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 2016/7/1.
  */
object RDD2DataFrame {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("RDD2DataFrameReflection").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    // 在Scala中使用反射方式进行RDD到DataFrame的转换,需要手动导入一个隐式转换
    import org.apache.spark.sql.Row
    import org.apache.spark.sql.types.{StructType,StructField,StringType};
    val students = sc.textFile("textdata/students.txt")
        .map(line => line.split(","))
          .map(array => Row(array(0),array(1),array(2)))

//    val schemaString = "id,name,age"
//    val schema = StructType(schemaString.split(",").map(fieldName=>StructField(fieldName,StringType,true)))

    val schema = StructType(
      Seq(
        StructField("id",StringType,true),
        StructField("name",StringType,true),
        StructField("age",IntegerType,true)
      )
    )

    // 直接使用RDD的toDF()方法即可转换为DataFrame
    val studentDF = sqlContext.createDataFrame(students,schema)

    println(studentDF.schema)
    studentDF.show()
    studentDF.registerTempTable("students")
    val teenagerDF = sqlContext.sql("select * from students where age <= 18")
    val teenagerRDD = teenagerDF.rdd

    teenagerRDD.collect().foreach(row=>{
      println(row.getAs[String]("id")+":"+row.getAs[String]("name")+":"+row.getAs[Int]("age"))
    })

    // 这个scala版本比java的版本呢要亲和一点,没有像JAVA一样按照字典排序,而是保证了我们的这个顺序！
    teenagerDF.map(row => Student(row(0).toString.toInt, row(1).toString, row(2).toString.toInt))
    teenagerDF.map(row => Student(row(0).toString.toInt, row(1).toString, row(2).toString.toInt))
      .collect().foreach(stu => println(stu.id + ":" + stu.name + ":" + stu.age))

    // 首先scala中保证了顺序的一致,见上面,其次scala中对这个row的使用,比java的row使用更丰富
    teenagerRDD.map(row => Student(row.getAs[String]("id").toInt, row.getAs[String]("name"), row.getAs[String]("age").toInt))
      .collect().foreach(stu => println(stu.id + ":" + stu.name + ":" + stu.age))

    teenagerRDD.map(row => {
      val map = row.getValuesMap[Any](Array("id","name","age"))
      Student(map("id").toString.toInt, map("name").toString, map("age").toString.toInt)
    }).collect().foreach(stu => println(stu.id + ":" + stu.name + ":" + stu.age))
  }
}
