package com.moqi.scala.ch06

/**
 * 有理数类 1
 *
 * @author moqi On 10/30/20 17:18
 */
class A01Rational(n: Int, d: Int) {
  println("Created " + n + "/" + d)
}

object A01Rational extends App {
  val rational = new A01Rational(1, 2)
  println(s"rational = ${rational}")
}