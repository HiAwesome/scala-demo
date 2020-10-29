package com.moqi.scala.ch03

import java.math.BigInteger

/**
 * 用类型参数化数组
 *
 * @author moqi On 10/29/20 11:03
 */
object A01 {

  def main(args: Array[String]): Unit = {
    val big = new BigInteger("12345")
    println(s"big = ${big}")

    greet1
    greet2

    println((1).+(2))

    val numNames = Array("zero", "one", "two")
    println(s"numNames = ${numNames.mkString("Array(", ", ", ")")}")
    val numNames2 = Array.apply("zero", "one", "two")
    println(s"numNames2 = ${numNames2.mkString("Array(", ", ", ")")}")
  }

  private def greet1 = {
    val greetStrings = new Array[String](3)

    greetStrings(0) = "Hello"
    greetStrings(1) = ", "
    greetStrings(2) = "world!\n"

    for (i <- 0 to 2) {
      print(greetStrings(i))
    }
  }

  private def greet2 = {
    val greetStrings = new Array[String](3)

    greetStrings.update(0, "Hello")
    greetStrings.update(1, ", ")
    greetStrings.update(2, "world!\n")

    for (i <- 0 to 2) {
      print(greetStrings.apply(i))
    }
  }
}
