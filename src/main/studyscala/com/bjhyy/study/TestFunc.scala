package com.bjhyy.study

object TestFunc {
  
  // 函数默认值的传递
  def sayMyName(name : String = "yasaka") = {
    println("hello " + name)
  }
  
  // 函数多个参数的传递
  def sumMoreParamters(elems : Int*) : Int = {
    var sum = 0
    for(elem <- elems){
      sum += elem
    }
    sum
  }
  
  // 函数的返回类型它可以自动推断
  def add(a:Int, b:Int) = a + b
  
  // 函数复用的时候有些参数可以用下划线来代替
  def add2 = add(_:Int, 2)
  
  // 柯里化函数
  def multiply(a:Int)(b:Int) = a * b
  
  def multiply2 = multiply(2)_
  
  // 递归函数必须要有定义返回类型
  def fac(n:Int) :Int = if(n==0) 1 else n * fac(n - 1)
  
  // 匿名函数 =>
  val t  =  () => { println("i love xuruyun") ; 200 }
  
  def func(c : ()=>Int) = {
    c()
  }
  
  def func2(callback : (Int , Int)=>Int ) = {
    callback(123,123)
  }

  def func3(callback : (Int , Int)=>Int,a:Int,b:Int ) = {
    callback(a,b)
  }

  def func4(callback : ((Int,Int))=>Int,a:Int,b:Int ) = {
    callback((a,b))
  }
  
  // 嵌套函数
  // 说白了呢就是一个函数里面定义了另外一个函数
  def add3(a:Int , b:Int, c:Int) = {
    def add2(c:Int , d:Int) = {
      c + d
    }
    add2(add2(a,b), c)
  }
  
  // 能否看懂??? 56行这个地方如何调用到???
  def sum(f: Int=>Int) : (Int, Int) =>Int = {
    def sumF(a:Int, b:Int) :Int = {
      if(a > b) 0 else f(a) + sumF(a+1 , b)
    }
    sumF
  }
  
  def main(args: Array[String]): Unit = {
    
    val sumF = sum( x => x * 2)
    println(sumF(2,3))
    
//    sayMyName("xuruyun")
//    sayMyName()
    
//    println(sumMoreParamters(1,2,3,4,5))
//    println(add(2,3))
//    println(add2(3))
    
//    println(multiply(123)(123))
//    println(multiply2(123))
    
//    println(fac(5))
    
//    println(t())
//    println( func( t ) )
    
//    println(func2( (a:Int , b:Int) => a*b ))
//    println(func2( (a:Int , b:Int) => a+b ))

    println(func3( (a:Int , b:Int) => a*b ,123,123))
    println(func3( _*_ ,123,123))

    println(func4( (a:(Int , Int)) => a._1*a._2 ,123,123))
    println(func4(_._1 ,123,12345))
//    println(add3(1,2,3))
  }
}