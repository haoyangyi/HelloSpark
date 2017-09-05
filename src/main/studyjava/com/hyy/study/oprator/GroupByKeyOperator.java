package com.hyy.study.oprator;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class GroupByKeyOperator {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("LineCount").setMaster(
				"local[2]");
		conf.set("spark.default.parallelism","5");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		// groupByKey 把相同的key的元素放到一起去
		List<Tuple2<String,Integer>> scoreList = Arrays.asList(
				new Tuple2<String, Integer>("xuruyun" , 150),
				new Tuple2<String, Integer>("liangyongqi" , 100),
				new Tuple2<String, Integer>("wangfei" , 100),
				new Tuple2<String, Integer>("wangfei" , 80));
		
		JavaPairRDD<String, Integer> rdd = sc.parallelizePairs(scoreList);

		System.out.println(rdd.getNumPartitions());

		rdd.sortByKey();
//		JavaPairRDD<String, Integer> rdd1= rdd.repartition(10);
//		System.out.println(rdd1.getNumPartitions());
//
//
//		JavaPairRDD<String, Iterable<Integer>> rdd2=rdd1.groupByKey(6);
//		System.out.println(rdd2.getNumPartitions());
//
//		JavaPairRDD<String, Iterable<Integer>> rdd3=rdd2.repartition(11);
//		System.out.println(rdd3.getNumPartitions());

//		JavaPairRDD<String, Iterable<Iterable<Integer>>> rdd4=rdd3.groupByKey();
//		System.out.println(rdd4.getNumPartitions());





//		rdd2.count();


//		JavaPairRDD<String, Iterable<Integer>> rdd4 = rdd2.sortByKey();
//		System.out.println(rdd4.getNumPartitions());
//		rdd4.count();

//		JavaRDD<String> rdd3=rdd2.map(new Function<Tuple2<String,Iterable<Integer>>, String>() {
//			@Override
//			public String call(Tuple2<String, Iterable<Integer>> stringIterableTuple2) throws Exception {
//				return stringIterableTuple2._1;
//			}
//		});
//
//		System.out.println(rdd3.getNumPartitions());
//		rdd3.count();


		sc.close();
	}
}
