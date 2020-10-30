package com.moqi.scala.ch06

/**
 * 有理数类 2
 *
 * @author moqi On 10/30/20 17:18
 */
class A02Rational(n: Int, d: Int) {
  override def toString: String = n + "/" + d
}

object A02Rational extends App {
  println(new A02Rational(1, 2))
}