package com.moqi.scala.ch06

/**
 * 有理数类 5
 *
 * @author moqi On 10/30/20 17:18
 */
class A06Rational(n: Int, d: Int) {
  require(d != 0, "有理数的分母不可以为 0")

  override def toString: String = n + "/" + d

  // 分子
  val numerator: Int = n
  // 分母
  val denominator: Int = d

  // 辅助构造方法
  def this(n: Int) = this(n, 1)

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
}

object A06Rational extends App {
  val three = new A06Rational(3)
  println(s"three = ${three}")
}