package com.hyy.study.stream;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import com.google.common.base.Optional;

import scala.Tuple2;

public class UpdateStateByKeyWordcount {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("UpdateStateByKeyWordcount").setMaster("local[2]");
		JavaStreamingContext jssc = new JavaStreamingContext(conf , Durations.seconds(5));
		jssc.checkpoint(".");
		
		JavaReceiverInputDStream<String> lines = jssc.socketTextStream("node24", 8888);
		JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Iterable<String> call(String line) throws Exception {
				return Arrays.asList(line.split(" "));
			}
		});
		JavaPairDStream<String, Integer> pairs = words.mapToPair(new PairFunction<String, String, Integer>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Tuple2<String, Integer> call(String word) throws Exception {
				return new Tuple2<String, Integer>(word, 1);
			}
		});
		JavaPairDStream<String, Integer> wordcounts = pairs.updateStateByKey(new Function2<List<Integer>, Optional<Integer>, Optional<Integer>>() {

			private static final long serialVersionUID = 1L;

			// 实际上,对于每个单词,每次batch计算的时候,都会调用这个函数,第一个参数values相当于这个batch中
			// 这个key对应的新的一组值,可能有多个,可能2个1,(xuruyun,1)(xuruyun,1),那么这个values就是(1,1)
			// 那么第二个参数表示的是这个key之前的状态,我们看类型Integer你也就知道了,这里是泛型咱们自己指定的
			
			@Override
			public Optional<Integer> call(List<Integer> values,
					Optional<Integer> state) throws Exception {
				
				// Optional其实有两个子类,一个子类是Some,一个子类是None
				// 就是key有可能之前从来都没有出现过,意味着之前从来没有更新过状态
				Integer newValue = 0;
				if(state.isPresent()){
					newValue = state.get();
				}
				for(Integer value : values){
					newValue += value;
				}
				
				return Optional.of(newValue);
			}
		});
		
		wordcounts.print();
		
		jssc.start();
		jssc.awaitTermination();
		jssc.stop();
		jssc.close();
	}
}
