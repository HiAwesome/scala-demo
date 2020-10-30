package com.moqi.scala.ch06

import scala.annotation.tailrec

/**
 * 有理数类 8
 * 隐式转换
 *
 * @author moqi On 10/30/20 17:18
 */
class A08Rational(n: Int, d: Int) {
  require(d != 0, "有理数的分母不可以为 0")

  private val g = gcd(n.abs, d.abs)
  // 分子
  val numerator: Int = n / g
  // 分母
  val denominator: Int = d / g

  // 辅助构造方法
  def this(n: Int) = this(n, 1)

  override def toString: String = numerator + "/" + denominator

  def add(that: A08Rational): A08Rational = {
    new A08Rational(
      numerator * that.denominator + denominator * that.numerator,
      denominator * that.denominator
    )
  }

  /**
   * 加号重载 add 方法
   */
  def +(that: A08Rational): A08Rational = add(that)

  /**
   * 加号重载类型是整数的方法
   */
  def +(i: Int): A08Rational = new A08Rational(numerator + i * denominator, denominator)

  def -(that: A08Rational): A08Rational = {
    new A08Rational(
      numerator * that.denominator - denominator * that.numerator,
      denominator * that.denominator
    )
  }

  def -(i: Int): A08Rational = new A08Rational(numerator - i * denominator, denominator)

  def *(that: A08Rational): A08Rational =
    new A08Rational(numerator * that.numerator, denominator * that.denominator)

  def *(i: Int): A08Rational = new A08Rational(numerator * i, denominator)

  def /(that: A08Rational): A08Rational =
    new A08Rational(numerator * that.denominator, denominator * that.numerator)

  def /(i: Int): A08Rational = new A08Rational(numerator, denominator * i)

  def lessThan(that: A08Rational): Boolean =
    this.numerator * that.denominator < that.numerator * this.denominator

  def max(that: A08Rational): A08Rational =
    if (this.lessThan(that)) that else this

  /**
   * 取两个数的最大公约数
   */
  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

object A08Rational extends App {
  // 在需要时自动将整数转换成有理数
  implicit def intToA08Rational(x: Int) = new A08Rational(x)

  val x = new A08Rational(2, 3)
  println(s"x = ${x}")
  println(s"10 * x = ${10 * x}")
}