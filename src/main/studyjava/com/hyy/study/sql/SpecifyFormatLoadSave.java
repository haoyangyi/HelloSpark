package com.hyy.study.sql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class SpecifyFormatLoadSave {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("SpecifyFormatLoadSave").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext sqlContext = new SQLContext(sc);

		//sqlContext.read().json()
		DataFrame peopleDF = sqlContext.read().format("json").load("textdata/people.json");
		peopleDF.printSchema();
		//peopleDF.select("name").write().parquet();
		peopleDF.select("name").write().format("parquet").save("textdata/peopleName.parquet");
//		peopleDF.select("name").write().format("json").save("textdata/people2.json");
	}
}
