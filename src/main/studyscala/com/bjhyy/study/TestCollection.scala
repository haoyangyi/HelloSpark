package com.bjhyy.study

object TestCollection {
  def main(args: Array[String]): Unit = {
    
    // 本质上是调用了类里面的apply方法
    val list = List(1,2,3,5,5)
    println(list(0))
    
    // :+ +: :: ++ :::
    // :+ +: :: 添加元素
    // 冒号朝向的是集合
    // ::: 拼接集合 只用于list
    // ++ 比较通用的拼接集合
    
//    println(6 :: list)
//    println(list.::(6))
//    
//    println(6 +: list)
//    println(list.+:(6))
//
//    println(list :+ 6)
//    println(list)
//    println(list.:+(6))
//    
//    val list2 = List(6)

//    println(list ::: list2)
//    println(list2 ::: list)
//
//    println(list ++ list2)
//    println(list2 ++ list)
//    
//    println( list:::6::Nil )
    
    // map 就是对集合里面的每一个元素依次来进行操作
//    val temp = list.map { x => x + 2 }
//    val temp = list.map { _ + 2 }
//    println(temp)
    
    // foreach 也是对集合里面的每一个元素依次来进行操作
   // 只不过foreach没有返回值
//    list.foreach { x => println(x) }
    
    // filter 是过滤元素,里面匿名函数如果返回True,则保留下来,返回false,过滤掉
//    println(list.filter { x => x > 3 })
//      println(list.filter { _ > 3 })
    
    // reduce 是对集合里面的元素依次来执行这个匿名函数的逻辑操作来进行汇总
//    println(list.reduce( (a ,b ) => a-b ))
//    println(list.reduce( _ - _ ))
    
    // foldLeft 是对集合里面的元素依次来执行这个匿名函数的逻辑操作来进行汇总,它有初始值
    //12355
    println(list.foldLeft(10)((a,b)=>a-b))
    println(list./:(10)((a,b)=>a-b))

//      println(list.foldRight(10)((a,b)=>a-b))
//      println(list./:(10)((a,b)=>a-b))
    
    // sortBy 由什么来进行排序,我们来指定
//    println(list.sortBy { x => -x })
    
    // scala中tuple元组取元素的时候要注意index是从1开始, ._n
    val tuple = (1,2,3,4)
    println(tuple._1)
    println(tuple._4)
    
    val listtest = List( ("yasaka", 100),("xuruyun", 100),("wangfei", 50) )
    println(listtest.sortBy(x=> (-x._2, x._1)))
  }
}