package com.moqi.scala.ch12

import scala.annotation.tailrec

/**
 * Ordered 特质
 *
 * @author moqi On 11/6/20 15:43
 */
object A04OrderedTrait {

  def main(args: Array[String]): Unit = {

    val half = new Rational(1, 2)
    val third = new Rational(1, 3)
    println(s"half < third = ${half < third}")
    println(s"half > third = ${half > third}")

  }

}

class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0, "有理数的分母不可以为 0")

  private val g = gcd(n.abs, d.abs)
  // 分子
  val numerator: Int = n / g
  // 分母
  val denominator: Int = d / g

  // 辅助构造方法
  def this(n: Int) = this(n, 1)

  override def toString: String = numerator + "/" + denominator

  def add(that: Rational): Rational = {
    new Rational(
      numerator * that.denominator + denominator * that.numerator,
      denominator * that.denominator
    )
  }

  /**
   * 加号重载 add 方法
   */
  def +(that: Rational): Rational = add(that)

  /**
   * 加号重载类型是整数的方法
   */
  def +(i: Int): Rational = new Rational(numerator + i * denominator, denominator)

  def -(that: Rational): Rational = {
    new Rational(
      numerator * that.denominator - denominator * that.numerator,
      denominator * that.denominator
    )
  }

  def -(i: Int): Rational = new Rational(numerator - i * denominator, denominator)

  def *(that: Rational): Rational =
    new Rational(numerator * that.numerator, denominator * that.denominator)

  def *(i: Int): Rational = new Rational(numerator * i, denominator)

  def /(that: Rational): Rational =
    new Rational(numerator * that.denominator, denominator * that.numerator)

  def /(i: Int): Rational = new Rational(numerator, denominator * i)

  def lessThan(that: Rational): Boolean =
    this.numerator * that.denominator < that.numerator * this.denominator

  def max(that: Rational): Rational =
    if (this.lessThan(that)) that else this

  /**
   * 取两个数的最大公约数
   */
  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def compare(that: Rational): Int =
    (this.numerator * that.denominator) - (that.numerator * this.denominator)
}
