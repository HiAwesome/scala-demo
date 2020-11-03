package com.moqi.scala.ch08

/**
 * 一等函数
 *
 * @author moqi On 11/3/20 10:32
 */
object A03FirstClassFunction {

  def main(args: Array[String]): Unit = {

    println(s"increase1(10) = ${increase1(10)}")
    println()

    println(s"increase2(10) = ${increase2(10)}")
    println()

    println(s"increase3(10) = ${increase3(10)}")
    println()

    println(someNumbers.foreach((x: Int) => println(x)))
    println()

    println(someNumbers.filter((x: Int) => x > 0))
    println()

  }

  private val increase1 = (x: Int) => x + 1

  private val increase2 = (x: Int) => x + 9999

  private val increase3 = (x: Int) => {
    println("We")
    println("Are")
    println("Here")
    x + 1
  }

  val someNumbers = List(-11, -10, -5, 0, 5, 10)

}
