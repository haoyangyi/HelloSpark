package com.bjhyy.study

object TestCollection2 {
  
  def main(args: Array[String]): Unit = {
    
		  // map
		  val map = Map[String, Integer](("yasaka"-> 100),("xuruyun", 100),("wangfei",50))
			// scala取值map里面的元素,需要注意它返回的是option,option有两个子类,有值some,无值none	  
		  val temp = map.get("yasaka")
		  println(temp.get)
		  println(map.getOrElse("annie", 101))
		  
		  for(key <- map.keys){
		    println(key)
		    println(map.getOrElse(key, "default"))
		  }
		  
		  val mutableMap = scala.collection.mutable.Map[String, Integer](("yasaka"-> 100),("xuruyun", 100),("wangfei",50))
		  println(mutableMap("yasaka"))
		  mutableMap("yasaka") = 1000
		  println(mutableMap)
  }
}