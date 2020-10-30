package com.moqi.scala.ch06

/**
 * 有理数类 3
 *
 * @author moqi On 10/30/20 17:18
 */
class A03Rational(n: Int, d: Int) {
  require(d != 0, "有理数的分母不可以为 0")
  override def toString: String = n + "/" + d
}

object A03Rational extends App {
  println(new A03Rational(1, 2))
  println(new A03Rational(1, 0))
}