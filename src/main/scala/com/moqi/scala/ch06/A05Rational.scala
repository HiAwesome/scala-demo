package com.moqi.scala.ch06

/**
 * 有理数类 5
 *
 * @author moqi On 10/30/20 17:18
 */
class A05Rational(n: Int, d: Int) {
  require(d != 0, "有理数的分母不可以为 0")

  override def toString: String = n + "/" + d

  // 分子
  val numerator: Int = n
  // 分母
  val denominator: Int = d

  def add(that: A05Rational): A05Rational = {
    new A05Rational(
      numerator * that.denominator + denominator * that.numerator,
      denominator * that.denominator
    )
  }

  def lessThan(that: A05Rational): Boolean =
    this.numerator * that.denominator < that.numerator * this.denominator

  def max(that: A05Rational): A05Rational =
    if (this.lessThan(that)) that else this
}

object A05Rational extends App {
  val oneHalf = new A05Rational(1, 2)
  println(s"oneHalf = ${oneHalf}")

  val twoThirds = new A05Rational(2, 3)
  println(s"twoThirds = ${twoThirds}")

  val sum1 = oneHalf add twoThirds
  println(s"sum1 = ${sum1}")
  println(s"sum1.numerator = ${sum1.numerator}")
  println(s"sum1.denominator = ${sum1.denominator}")
}