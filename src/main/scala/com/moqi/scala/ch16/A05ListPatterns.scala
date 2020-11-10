package com.moqi.scala.ch16

/**
 * 列表模式
 *
 * @author moqi On 11/10/20 10:53
 */
object A05ListPatterns {

  def main(args: Array[String]): Unit = {

    val fruit = List("apple", "orange", "pears")

    val List(a, b, c) = fruit
    // 事先知道列表长度
    println(s"a = ${a}, b = ${b}, c = ${c}")
    // 事先不知道列表长度
    val d :: e :: rest = fruit
    println(s"d = ${d}, e = ${e}, rest = ${rest}")
    println()

    val sort = List(9, 3, 2, 5, 0, 100)
    println(s"sort = ${sort}")
    println(s"isort(sort) = ${isort(sort)}")

  }

  /**
   * 列表模式匹配方式的插入排序
   */
  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case x :: xs1 => insert(x, isort(xs1))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }

}
