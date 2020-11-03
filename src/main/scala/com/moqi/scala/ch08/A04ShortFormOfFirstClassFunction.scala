package com.moqi.scala.ch08

/**
 * 函数字面量的简写形式
 *
 * @author moqi On 11/3/20 10:43
 */
object A04ShortFormOfFirstClassFunction {

  def main(args: Array[String]): Unit = {

    println(someNumbers.foreach(x => println(x)))
    println()

    println(someNumbers.filter(x => x > 0))
    println()

  }

  val someNumbers = List(-11, -10, -5, 0, 5, 10)

}
