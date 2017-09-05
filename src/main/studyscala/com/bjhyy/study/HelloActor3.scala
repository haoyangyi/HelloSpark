package com.bjhyy.study

import scala.actors.Actor

// 两个Actor它们之间互相发消息

case class Message(content:String, sender: Actor)

class YasakaActor extends Actor{
  def act()= {
    while(true) {
      receive{
        case Message(content, sender) => {println("received message is " + content);
                                          sender ! 1000000000}
      }
    }
  }
}

class WangfeiActor(lover : Actor) extends Actor{
  def act () = {
	  var flag = true
	  lover ! Message("could we have a date?", this)    
    while(flag){
      receive{
        case Message(content,sender) => println(content); 
        case x:Int => println("you don't love me anymore! you love xuruyun! ");flag = false
      }
    }
  }
}

object HelloActor3 {
  def main(args: Array[String]): Unit = {
    val yasaka = new YasakaActor
    val wangfei = new WangfeiActor(yasaka)
    yasaka.start()
    wangfei.start()
  }
}