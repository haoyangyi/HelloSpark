package com.bjhyy.study

object TestFunc2 {
  
   // switch
    def testmatch(n:Any) = {
      n match {
        case x:Double => { println("Double"); x }
        case 100 => { println("100") ; n }
        case x:Int => { println("Integer"); x }
        case s:String => println("String"); s
        case _ => println("default") ; "default case"
      }
    }
    
    def sumMoreParameters(elems : Int*) = {
      var sum = 0
      for(elem <- elems){
        sum += elem
      }
      sum
    }
  
  def main(args: Array[String]): Unit = {
    
//    println( 1 to 10)
//    println(1.to(10))
//    
//    println(1.until(10))
//    println(1 until 10)
//    
//    for(i <- 1 to 100){
//      println(i)
//    }
//    
//    for(i <- 1 until 100){
//    	println(i)
//    }
    
//    for(i <- 1 until 100 if i % 2 == 1 ; if i % 5 > 3){
//      println(i)
//    }
    
    println( testmatch(100.0) )
    
//    println(sumMoreParameters(1,2,3,4,5))
//    println(sumMoreParameters( 1 to 5 :_* ))
  }
}