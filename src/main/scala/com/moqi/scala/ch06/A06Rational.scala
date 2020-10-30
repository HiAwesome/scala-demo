package com.moqi.scala.ch06

import scala.annotation.tailrec

/**
 * 有理数类 6
 *
 * @author moqi On 10/30/20 17:18
 */
class A06Rational(n: Int, d: Int) {
  require(d != 0, "有理数的分母不可以为 0")

  private val g = gcd(n.abs, d.abs)
  // 分子
  val numerator: Int = n / g
  // 分母
  val denominator: Int = d / g

  // 辅助构造方法
  def this(n: Int) = this(n, 1)

  override def toString: String = numerator + "/" + denominator

  def add(that: A06Rational): A06Rational = {
    new A06Rational(
      numerator * that.denominator + denominator * that.numerator,
      denominator * that.denominator
    )
  }

  def lessThan(that: A06Rational): Boolean =
    this.numerator * that.denominator < that.numerator * this.denominator

  def max(that: A06Rational): A06Rational =
    if (this.lessThan(that)) that else this

  /**
   * 取两个数的最大公约数
   */
  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

object A06Rational extends App {
  val gcd = new A06Rational(66, 42)
  println(s"gcd = ${gcd}")
}