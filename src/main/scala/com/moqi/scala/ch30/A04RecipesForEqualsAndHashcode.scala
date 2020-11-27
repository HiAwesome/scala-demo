package com.moqi.scala.ch30

import scala.annotation.tailrec

/**
 * 如何编写 equals 和 hashCode 方法
 *
 * @author moqi On 11/27/20 15:18
 */
object A04RecipesForEqualsAndHashcode {

  def main(args: Array[String]): Unit = {

    val r1 = new Rational(1, 2)
    val r2 = new Rational(3, 6)
    println(s"r1 == r2 = ${r1 == r2}")
    println()

  }

}

/**
 * 带有 equals 和 hashCode 的 Rational 类
 */
class Rational(n: Int, d: Int) {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)

  @tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val numer = (if (d < 0) -n else n) / g
  val denom = d.abs / g

  override def equals(other: Any): Boolean = other match {
    case that: Rational =>
      (that canEqual this) &&
        numer == that.numer &&
        denom == that.denom
    case _ => false
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Rational]

  /**
   * override def hashCode(): Int = (numer, denom).##
   * 如果发现一个特定的 hashCode 计算影响到程序的性能，也可以考虑将其缓存起来。
   * 如果对象是不可变的，可以在对象创建时计算哈希吗并保存到一个字段中，可以通过 val 而不是 def 来重写 hashCode
   * 用内存来换取计算时间
   */
  override val hashCode: Int = (numer, denom).##

  override def toString: String =
    if (denom == 1) numer.toString else numer + "/" + denom
}