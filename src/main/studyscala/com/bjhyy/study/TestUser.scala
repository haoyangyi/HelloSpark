package com.bjhyy.study

import org.apache.hadoop.fs.Path

// 默认构造器
class User(name: String, var age: Int){
  
  var hobby = ""
  var name2 = ""
  println("hello world!!!")
  
  def this(){
    this("yasaka",35)
  }
  
  def this(name: String, age: Int, hobby: String){
	  this("yasaka",35)
	  this.hobby = hobby
	  this.name2 = name
  }
  
}

object User {
	def main(args: Array[String]): Unit = {
	  
	  val user = new User("xuruyun", 30, "man")
//	  println(user.name)
	  user.age = 80
	  println(user.age)
	  println(user.name2)

	  var s1:String=null
		var s2:String=null
		val s3=("sssss","aaaaaa")

		s1=s3._1
		s2=s3._2
//		(s1,s2)==s3
		println(s1+"  "+s2)
		val (s4:String,s5:String)=s3
		println(s4+"  "+s5)
	}
  
}