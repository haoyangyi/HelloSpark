package com.bjhyy.study

import scala.actors.Actor

// actor发送消息可以发送case class

case class Message0(content : String)

class HelloActor2 extends Actor{
  def act() ={
    while(true){
       receive {
       case x:String => println("string")
       case Message0(content:String) => println(content)
       case _ => println("default")
      }
    }
  }
}


object HelloActor2 {
 def main(args: Array[String]): Unit = {
   val actor = new HelloActor2
   actor.start()
   actor ! "hello"
   actor ! Message0("xuruyun")
 }  
}