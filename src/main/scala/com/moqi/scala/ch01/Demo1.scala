package com.moqi.scala.ch01

/**
 * 测试 Scala
 *
 * @author moqi On 10/28/20 11:50
 */
object Demo1 {

  def main(args: Array[String]): Unit = {

    var capital = Map("US" -> "Washington", "France" -> "Paris")
    capital += ("Japan" -> "Tokyo")
    println(capital("France"))


    def factorial(x: BigInt): BigInt =
      if (x == 0) 1 else x * factorial(x - 1)

    println(factorial(30))
  }

}

