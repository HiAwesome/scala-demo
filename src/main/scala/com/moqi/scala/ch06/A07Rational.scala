package com.moqi.scala.ch06

import scala.annotation.tailrec

/**
 * 有理数类 7
 *
 * @author moqi On 10/30/20 17:18
 */
class A07Rational(n: Int, d: Int) {
  require(d != 0, "有理数的分母不可以为 0")

  private val g = gcd(n.abs, d.abs)
  // 分子
  val numerator: Int = n / g
  // 分母
  val denominator: Int = d / g

  // 辅助构造方法
  def this(n: Int) = this(n, 1)

  override def toString: String = numerator + "/" + denominator

  def add(that: A07Rational): A07Rational = {
    new A07Rational(
      numerator * that.denominator + denominator * that.numerator,
      denominator * that.denominator
    )
  }

  /**
   * 加号重载 add 方法
   */
  def +(that: A07Rational): A07Rational = add(that)

  def *(that: A07Rational): A07Rational =
    new A07Rational(numerator * that.numerator, denominator * that.denominator)

  def lessThan(that: A07Rational): Boolean =
    this.numerator * that.denominator < that.numerator * this.denominator

  def max(that: A07Rational): A07Rational =
    if (this.lessThan(that)) that else this

  /**
   * 取两个数的最大公约数
   */
  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

object A07Rational extends App {
  val x = new A07Rational(1, 2)
  println(s"x = ${x}")

  val y = new A07Rational(2, 3)
  println(s"y = ${y}")

  val sum1 = x + y
  println(s"sum1 = ${sum1}")

  val product1 = x * y
  println(s"product1 = ${product1}")

  println(x + x * y)
  println((x + x) * y)
  println(x + (x * y))
}