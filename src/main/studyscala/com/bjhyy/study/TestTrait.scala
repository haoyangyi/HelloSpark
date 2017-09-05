package com.bjhyy.study

trait Speak {
  val name : String
  def speak() = println(name + " is speaking")
}

trait Read {
	val name : String
	def read() = println(name + " is reading")
}

class Animal(name:String)

class Cat(override val name:String) extends Animal(name:String) with Speak{
  def listen() = println(name + " is listenning")
}


object TestTrait {
  def main(args: Array[String]): Unit = {
    val cat = new Cat("hello kitty") with Read
    cat.listen()
    cat.speak()
  }
}