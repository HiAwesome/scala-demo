package com.moqi.scala.ch08

/**
 * 部分应用的函数
 *
 * @author moqi On 11/3/20 14:52
 */
object A06PartFunction {

  def main(args: Array[String]): Unit = {

    // someNumbers.foreach(println _) 等于下一种形式
    someNumbers.foreach(println)
    println()

    println(s"sum(1, 2, 3) = ${sum(1, 2, 3)}")
    println()

    val a = sum _
    println(s"a = ${a}")
    println(s"a(1, 2, 3) = ${a(1, 2, 3)}")
    println(s"a.apply(1, 2, 3) = ${a.apply(1, 2, 3)}")
    println()

    val b = sum(1, _:Int, 3)
    println(s"b(2) = ${b(2)}")
    println(s"b(5) = ${b(5)}")
    println()

  }

  val someNumbers = List(-11, -10, -5, 0, 5, 10)

  def sum(a: Int, b: Int, c: Int): Int = a + b + c

}
