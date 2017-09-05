package com.bjhyy.study

class SpecialPerson(name:String)
class Older(val name:String)
class Child(val name:String)
class Teacher(val name:String)

object Implicit01 {
  
  implicit def object2SpecialPerson(obj : Object) : SpecialPerson = {
    if( obj.getClass == classOf[Older]){
      val older = obj.asInstanceOf[Older]
      new SpecialPerson(older.name)
    }else if(obj.getClass == classOf[Child]){
      val child = obj.asInstanceOf[Child]
      new SpecialPerson(child.name)
    }else{
      println("Nil")
      Nil
    }
  }
  
  var sumTickits = 0
  
  def buySpecialTicket(specialPerson : SpecialPerson) ={
    sumTickits += 1
    println(sumTickits)
  }
  
  def main(args: Array[String]): Unit = {
    val older = new Older("laowang")
    buySpecialTicket(older)
    val child = new Child("xiaoming")
    buySpecialTicket(child)
    val teacher = new Teacher("yasaka")
    buySpecialTicket(teacher)
  }
}