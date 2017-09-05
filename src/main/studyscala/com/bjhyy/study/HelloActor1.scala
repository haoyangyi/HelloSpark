package com.bjhyy.study

import scala.actors.Actor

// 如何给actor发送消息

class HelloActor extends Actor{
  def act() = {
    while(true){
      receive {
       case x:String => println("string")
       case x:Int => println("int")
       case _ => println("default")
      }
    }
  }
}



object HelloActor1 {
  def main(args: Array[String]): Unit = {
    val actor = new HelloActor
    actor.start()
    actor ! "hello"
  }
}