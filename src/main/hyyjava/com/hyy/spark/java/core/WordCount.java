package com.hyy.spark.java.core;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.storage.StorageLevel;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by root on 2016/11/29.
 */
public class WordCount {


    public static void main(String[] args) {
        SparkConf conf= new SparkConf().setAppName("wordcount").setMaster("local");
//        conf.set("spark.default.parallelism","5");
        conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
        conf.registerKryoClasses(new Class[]{String.class});
        JavaSparkContext sc=new JavaSparkContext(conf);

        List<Tuple2<String,Integer>> scoreList = Arrays.asList(
                new Tuple2<String, Integer>("xuruyun" , 150),
                new Tuple2<String, Integer>("liangyongqi" , 100),
                new Tuple2<String, Integer>("wangfei" , 100),
                new Tuple2<String, Integer>("wangfei" , 80));

        JavaPairRDD<String, Integer> rdd = sc.parallelizePairs(scoreList);
        rdd.sortByKey();
        JavaRDD<String> textFile=sc.textFile("textdata/wordcount1.txt");


        //MEMORY_AND_DISK
        //Block rdd_3_0 stored as values in memory (estimated size 15.6 MB, free 15.7 MB)
        //MEMORY_AND_DISK_SER
        //Block rdd_3_0 stored as bytes in memory (estimated size 20.3 MB, free 20.5 MB)

        textFile=textFile.persist(StorageLevel.MEMORY_AND_DISK());
        JavaRDD<String> words = textFile.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterable<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" "));
            }
        });

        JavaPairRDD<String, Integer> pairs=words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s,1);
            }
        });


        JavaPairRDD<String, Integer> counts= pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer value1, Integer value2) throws Exception {
                return value1+value2;
            }
        });

        JavaPairRDD<Integer, String> temp = counts.mapToPair(new PairFunction<Tuple2<String,Integer>, Integer, String>() {

            private static final long serialVersionUID = 1L;

            @Override
            public Tuple2<Integer, String> call(Tuple2<String, Integer> tuple)
                    throws Exception {
                return new Tuple2<Integer, String>(tuple._2, tuple._1);
            }
        });

        JavaPairRDD<Integer, String> sorts=temp.sortByKey();
        JavaPairRDD<String, Integer> sorted=sorts.mapToPair(new PairFunction<Tuple2<Integer,String>, String, Integer>() {
            private static final long serialVersionUID = 1L;
            @Override
            public Tuple2<String, Integer> call(Tuple2<Integer, String> tuple)
                    throws Exception {
                return new Tuple2<String, Integer>(tuple._2, tuple._1);
            }
        });

        sorted.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            @Override
            public void call(Tuple2<String, Integer> tuple) throws Exception {
                System.out.println( tuple._1 + " : " + tuple._2);
            }
        });
        sc.stop();
        sc.close();

    }
}
