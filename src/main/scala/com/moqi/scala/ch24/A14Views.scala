package com.moqi.scala.ch24

import scala.collection.IndexedSeqView

/**
 * 视图：一个用于调和效率和模块化之间矛盾的强大工具
 *
 * @author moqi On 11/24/20 19:23
 */
object A14Views {

  def main(args: Array[String]): Unit = {

    func1

    func2

  }

  private def func2: Unit = {
    val arr = (0 to 9).toArray
    println(s"arr = ${arr.mkString("Array(", ", ", ")")}")
    val subArr = arr.view.slice(3, 6)
    println(s"subArr = ${subArr}")
    println()

    // val actors = for(i <- 1 to 10) yield actor { ... }
    // val actors = (1 to 10) map actor (i => actor { ... })
    // val actors = for(i <- (1 to 10).view) yield actor { ... }
  }

  def isPalindrome(x: String) = x == x.reverse

  /**
   * 并不会构造 1000000 个的子 words
   * findPalindrome(words.view take 1000000)
   */
  def findPalindrome(s: Seq[String]): Option[String] = s find isPalindrome


  private def func1: Unit = {
    val v = Vector(1 to 10: _*)
    println(s"v = ${v}")
    println(s"v map (_ + 1) map (_ * 2) = ${v map (_ + 1) map (_ * 2)}")
    println()

    // println(s"(v.view map (_ + 1) map (_ * 2)).force = ${(v.view map (_ + 1) map (_ * 2)).force}")
    println(s"(v.view map (_ + 1) map (_ * 2)).to(Vector) = ${(v.view map (_ + 1) map (_ * 2)).to(Vector)}")
    println()

    val vv = v.view
    println(s"vv = ${vv}")
    val vv1 = vv map (_ + 1)
    println(s"vv1 = ${vv1}")
    val vv2 = vv1 map (_ * 2)
    println(s"vv2 = ${vv2}")
    println(s"vv2.to(Vector) = ${vv2.to(Vector)}")
    println()
  }
}
