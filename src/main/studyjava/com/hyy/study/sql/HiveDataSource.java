package com.hyy.study.sql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext;

public class HiveDataSource {

	/*
	 * 0,把hive里面的hive-site.xml放到spark/conf/目录下
	 * 1,启动Hive
	 * 2,您首先启动MySQL
	 * 3,启动HDFS
	 * 4,初始化HiveContext
	 * 5,打包运行
	 * 
	 * 如果你所在的客户端没有把hive-site.xml发送到每一个spark所在的conf目录下的话,就必须--files ./conf/hive-site.xml
	 * 
	 * Found both spark.executor.extraClassPath and SPARK_CLASSPATH. Use only the former.
	 * 出现这个错误,你就把Spark-env.sh里面的注释掉
	 * 
	 * ./bin/spark-submit --master spark://node21:7077 --class com.shsxt.study.sql.HiveDataSource sparksqlhive20161101.jar 
	 * 
	 * ./bin/spark-submit --master spark://node21:7077 --deploy-mode cluster --class com.shsxt.study.sql.HiveDataSource 
	 * --files ./conf/hive-site.xml   hdfs://node21:8020/sparksqlhive20161101.jar 
	 * 
	 * ./bin/spark-submit --master yarn-client --class com.sxt.study.sql.HiveDataSource ./sparksqlhive20161203.jar
	 * 
	 * javax.jdo.JDOFatalUserException: Class org.datanucleus.api.jdo.JDOPersistenceManagerFactory was not found.
	 * java.lang.ClassNotFoundException: org.datanucleus.api.jdo.JDOPersistenceManagerFactory 
	 * 
	 * ./bin/spark-submit --master yarn-cluster --class com.shsxt.study.sql.HiveDataSource 
	 * --jars ./lib/datanucleus-api-jdo-3.2.6.jar,./lib/datanucleus-core-3.2.10.jar,./lib/datanucleus-rdbms-3.2.9.jar 
	 *  --files ./conf/hive-site.xml ./sparksqlhive20161101.jar 
	 */
	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("HiveDataSource");
		JavaSparkContext sc = new JavaSparkContext(conf);
		// 这里主要它要的是SparkContext
		SQLContext hiveContext = new HiveContext(sc.sc());
		
		// 判断是否存储过student_infos这张表，如果存储过则删除
		hiveContext.sql("DROP TABLE IF EXISTS student_infos");
		// 重建
		hiveContext.sql("CREATE TABLE IF NOT EXISTS student_infos ( name STRING , age INT )");
		// 加载数据，这里是HIVE的东西，我们主要是讲Spark SQL，所以HIVE的东西我们就不多言了
		hiveContext.sql("LOAD DATA LOCAL INPATH '/usr/sparktestdata/student_infos.txt' INTO TABLE student_infos");
	
		// 一样的方式导入其它表
		hiveContext.sql("DROP TABLE IF EXISTS student_scores");
		hiveContext.sql("CREATE TABLE IF NOT EXISTS student_scores ( name STRING , score INT )");
		hiveContext.sql("LOAD DATA LOCAL INPATH '/usr/sparktestdata/student_scores.txt' INTO TABLE student_scores");
	
		// 关联两张表，查询成绩大于80分的学生
		DataFrame goodStudentsDF = hiveContext.sql("SELECT si.name, si.age, ss.score FROM student_infos si JOIN student_scores ss ON si.name=ss.name WHERE ss.score>=80");
	
		// 我们得到这个数据是不是还得存回HIVE表中！
		hiveContext.sql("DROP TABLE IF EXISTS good_student_infos");
		goodStudentsDF.saveAsTable("good_student_infos");
		
		// 然后如果是一个HIVE表我们怎么给它读过来呢？
		DataFrame temp = hiveContext.table("good_student_infos");
		Row[] rows = temp.collect();
		for(Row row : rows){
			System.out.println(row);
		}
		
		sc.close();
	}
}
