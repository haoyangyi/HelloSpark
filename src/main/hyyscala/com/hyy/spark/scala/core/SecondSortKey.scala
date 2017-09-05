package com.hyy.spark.scala.core

/**
  * Created by root on 2016/12/2.
  */
class SecondSortKey(val first:Int, val second:Int) extends Ordered[SecondSortKey] with Serializable{
  override def compare(that: SecondSortKey): Int = {
    if(this.first - that.first != 0)
    {
      this.first - that.first
    }else {
      this.second - that.second
    }
  }
}
