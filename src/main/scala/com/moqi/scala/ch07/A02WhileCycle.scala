package com.moqi.scala.ch07

import scala.annotation.tailrec
import scala.io.StdIn.readLine

/**
 * while 循环
 *
 * @author moqi On 11/2/20 11:14
 */
object A02WhileCycle extends App {

  val z1 = gcdLoop(1024, 372)
  println(s"z1 = ${z1}")

  val z2 = gcd(1024, 372)
  println(s"z2 = ${z2}")

  assert(z1 == z2)

  read

  /**
   * 用 do-while 读取标准输入
   */
  private def read: Unit = {
    var line = ""
    do {
      line = readLine()
      println(s"line = ${line}")
    } while (line != "")
    println()
  }

  /**
   * 警告：类型 Unit 和 String 比较将永远返回 true
   */
  private def unitCompareString: Unit = {
    var line = ""
    // Comparing unrelated types: Unit and String
    //noinspection ComparingUnrelatedTypes
    while ((line = readLine()) != "") {
      println(s"line = ${line}")
    }
  }

  /**
   * while 循环计算最大公约数
   */
  private def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y

    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }

    b
  }

  /**
   * 递归计算最大公约数
   */
  @tailrec
  private def gcd(x: Long, y: Long): Long = {
    if (y == 0) x else gcd(y, x % y)
  }


}
