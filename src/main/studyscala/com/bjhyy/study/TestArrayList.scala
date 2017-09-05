package com.bjhyy.study

import java.util._

object TestArrayList {
  def main(args: Array[String]): Unit = {
    // 无缝整合Java
    
    var list = new ArrayList[Any]
    list.add("yasaka")
    println(list.get(0))
    
    val it = list.iterator()
    while(it.hasNext()){
      println(it.next())
    }
    
    val stu = new Student("yasaka", 35)
    println(stu)
  }
}