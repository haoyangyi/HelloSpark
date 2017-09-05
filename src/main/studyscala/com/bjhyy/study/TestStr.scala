package com.bjhyy.study

/**
  * Created by root on 2017/5/4.
  */
object TestStr {
  def main(args: Array[String]): Unit = {
    val sqlText =
      s"""
         |SELECT hhh AS date, 0 AS active_count,
         | CASE client_type WHEN 'android' THEN 0 WHEN 'ios' THEN 3 ELSE client_type END AS client_type,
         | version,
         | COUNT(uid) AS reg_counthao
         |FROM temp_reg_user
         |GROUP BY client_type,version
        """.stripMargin

    println(s"统计SQL：${sqlText}")
  }
}
