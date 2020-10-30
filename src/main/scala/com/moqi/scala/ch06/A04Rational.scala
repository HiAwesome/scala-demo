package com.moqi.scala.ch06

/**
 * 有理数类 4
 *
 * @author moqi On 10/30/20 17:18
 */
class A04Rational(n: Int, d: Int) {
  require(d != 0, "有理数的分母不可以为 0")

  override def toString: String = n + "/" + d

  // 分子
  val numerator: Int = n
  // 分母
  val denominator: Int = d

  def add(that: A04Rational): A04Rational = {
    new A04Rational(
      numerator * that.denominator + denominator * that.numerator,
      denominator * that.denominator
    )
  }
}

object A04Rational extends App {
  val oneHalf = new A04Rational(1, 2)
  println(s"oneHalf = ${oneHalf}")

  val twoThirds = new A04Rational(2, 3)
  println(s"twoThirds = ${twoThirds}")

  val sum1 = oneHalf add twoThirds
  println(s"sum1 = ${sum1}")
  println(s"sum1.numerator = ${sum1.numerator}")
  println(s"sum1.denominator = ${sum1.denominator}")
}