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

    val greetStrings = new Array[String](3)

    greetStrings(0) = "Hello"
    greetStrings(1) = ", "
    greetStrings(2) = "world!\n"

    for (i <- 0 to 2) {
      print(greetStrings(i))
    }
  }

}
