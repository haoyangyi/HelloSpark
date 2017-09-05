package com.hyy.study.core;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.List;

public class GroupTopN {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("GroupTopN").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> lines = sc.textFile("score.txt");
		JavaPairRDD<String, Integer> pairs = lines
				.mapToPair(new PairFunction<String, String, Integer>() {

					private static final long serialVersionUID = 1L;

					@Override
					public Tuple2<String, Integer> call(String line)
							throws Exception {
						String[] arr = line.split(" ");
						return new Tuple2<String, Integer>(arr[0], Integer
								.valueOf(arr[1]));
					}
				});
		JavaPairRDD<String, Iterable<Integer>> groupedPairs = pairs
				.groupByKey();
		
		final List<String> keys = groupedPairs.map(new Function<Tuple2<String,Iterable<Integer>>,String>() {
 
			private static final long serialVersionUID = 1L;

			@Override
			public String call(Tuple2<String, Iterable<Integer>> tuple)
					throws Exception {
				return tuple._1;
			}
		}).collect();
		
		for(int i=0; i<keys.size() ;i++){
			
			final int index = i; 
			
			groupedPairs.filter(new Function<Tuple2<String,Iterable<Integer>>, Boolean>() {
				
				private static final long serialVersionUID = 1L;
				
				@Override
				public Boolean call(Tuple2<String, Iterable<Integer>> tuple)
						throws Exception {
					return tuple._1.equals(keys.get(index));
				}
			}).flatMap(new FlatMapFunction<Tuple2<String,Iterable<Integer>>, Integer>() {
				
				private static final long serialVersionUID = 1L;
				
				@Override
				public Iterable<Integer> call(Tuple2<String, Iterable<Integer>> tuple)
						throws Exception {
					return tuple._2;
				}
			}).mapToPair(new PairFunction<Integer, Integer, String>() {
				
				private static final long serialVersionUID = 1L;
				
				@Override
				public Tuple2<Integer, String> call(Integer v) throws Exception {
					return new Tuple2<Integer,String>(v, keys.get(index));
				}
			}).sortByKey(false).mapToPair(new PairFunction<Tuple2<Integer,String>, String, Integer>() {
				
				private static final long serialVersionUID = 1L;
				
				@Override
				public Tuple2<String, Integer> call(Tuple2<Integer, String> tuple)
						throws Exception {
					return new Tuple2<String,Integer>(tuple._2, tuple._1);
				}
			}).foreach(new VoidFunction<Tuple2<String,Integer>>() {
				
				private static final long serialVersionUID = 1L;
				
				@Override
				public void call(Tuple2<String, Integer> tuple) throws Exception {
					System.out.println(tuple._1 + " " + tuple._2);
				}
			});;
		}
		
		
//		JavaPairRDD<String, Iterable<Integer>> top2score = groupedPairs
//				.mapToPair(new PairFunction<Tuple2<String, Iterable<Integer>>, String, Iterable<Integer>>() {
//
//					private static final long serialVersionUID = 1L;
//
//					@Override
//					public Tuple2<String, Iterable<Integer>> call(
//							Tuple2<String, Iterable<Integer>> tuple)
//							throws Exception {
//						List<Integer> list = new ArrayList<Integer>();
//						Iterable<Integer> scores = tuple._2;
//						Iterator<Integer> it = scores.iterator();
//						while (it.hasNext()) {
//							Integer score = it.next();
//							list.add(score);
//						}
//						Collections.sort(list, new Comparator<Integer>(){
//							@Override
//							public int compare(Integer o1, Integer o2) {
//								return -(o1-o2);
//							}
//						});
//						list = list.subList(0, 2);
//						return new Tuple2<String, Iterable<Integer>>(tuple._1,
//								list);
//					}
//				});
//
//		top2score.foreach(new VoidFunction<Tuple2<String,Iterable<Integer>>>() {
//			
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void call(Tuple2<String, Iterable<Integer>> tuple) throws Exception {
//				System.out.println(" city : " + tuple._1);
//				Iterator<Integer> scores = tuple._2.iterator();
//				while(scores.hasNext()){
//					Integer score = scores.next();
//					System.out.println(score);
//				}
//				System.out.println("========================");
//			}
//		});
		
		sc.close();
	}
}
