package com.bjhyy.study

class Car(val name:String)

class SuperMan(name:String){
  def emitLaser() = println("emit a pingpang ball !!!!")
}


object Implicit02 {
  
  implicit def car2superman(car : Car) : SuperMan = {
    new SuperMan(car.name)
  }
  
  def main(args: Array[String]): Unit = {
    val car = new Car("qingtianzhu")
    car.emitLaser()
  }
}