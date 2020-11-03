package com.moqi.scala.ch08

import java.io.PrintStream

/**
 * 特殊的函数调用形式
 *
 * @author moqi On 11/3/20 15:55
 */
object A08SpecialFunctionCallForm {

  def main(args: Array[String]): Unit = {

    echo("one")
    println()

    echo("Hello", "world")
    println()

    val arr = Array("What's", "up", "doc?")
    println(s"arr = ${arr.mkString("Array(", ", ", ")")}")
    // 装包与拆包
    echo(arr: _*)
    println()

    println(s"speed(100, 10) = ${speed(100, 10)}")
    println(s"speed(distance = 100, time = 10) = ${speed(distance = 100, time = 10)}")
    println(s"speed(time = 10, distance = 100) = ${speed(time = 10, distance = 100)}")
    println()

    printTime()
    printTime(Console.err)
    println()

    printTime2()
    printTime2(out = Console.err)
    // 第一位可以不写参数名，第二位则不可以
    printTime2(Console.err)
    printTime2(divisor = 1000)
    println()

  }

  def printTime2(out: PrintStream = Console.out, divisor: Int = 1): Unit =
    out.println("time2 = " + System.currentTimeMillis() / divisor)

  /**
   * 缺省值参数
   */
  def printTime(out: PrintStream = Console.out): Unit = out.println("time1 = " + System.currentTimeMillis())

  /**
   * 带名字的参数，方便使用不同的顺序调用方法
   */
  def speed(distance: Float, time: Float): Float = distance / time

  /**
   * 重复参数（可变长度的参数列表）
   */
  def echo(args: String*): Unit = for (arg <- args) println(s"arg = $arg")

}
