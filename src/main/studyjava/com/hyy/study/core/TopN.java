package com.hyy.study.core;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.List;

public class TopN {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		JavaRDD<String> lines = sc.textFile("textdata/top.txt");
		JavaPairRDD<Integer, String> pairs = lines.mapToPair(new PairFunction<String, Integer, String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Tuple2<Integer, String> call(String value) throws Exception {
				return new Tuple2<Integer,String>(Integer.valueOf(value),value);
			}
		});
		List<String> results = pairs.sortByKey(false).map(new Function<Tuple2<Integer,String>, String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public String call(Tuple2<Integer, String> tuple) throws Exception {
				return tuple._2;
			}
		}).take(3);
		for(String result: results){
			System.out.println(result);
		}
		
		sc.close();
	}
}
