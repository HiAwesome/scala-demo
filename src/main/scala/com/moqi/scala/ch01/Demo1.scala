package com.moqi.scala.ch01

/**
 * 测试 Scala
 *
 * @author moqi On 10/28/20 11:50
 */
object Demo1 {

  def main(args: Array[String]): Unit = {

    capital()

    scalaFactorial()

    javaFactorial()
  }

  private def capital(): Unit = {
    var capital = Map("US" -> "Washington", "France" -> "Paris")
    capital += ("Japan" -> "Tokyo")
    println(capital("France"))
  }

  private def scalaFactorial(): Unit = {
    def factorial(x: BigInt): BigInt =
      if (x == 0) 1 else x * factorial(x - 1)

    println(factorial(30))
  }

  private def javaFactorial(): Unit = {
    import java.math.BigInteger

    def factorial(x: BigInteger): BigInteger =
      if (x == BigInteger.ZERO)
        BigInteger.ONE
      else
        x.multiply(factorial(x.subtract(BigInteger.ONE)))

    println(factorial(new BigInteger("30")))
  }


}

