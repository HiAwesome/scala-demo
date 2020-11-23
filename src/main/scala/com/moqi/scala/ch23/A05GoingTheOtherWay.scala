package com.moqi.scala.ch23

/**
 * 反过来
 * 每个 map、flatMap 和 filter 的应用也可以由 for 表达式来表示
 *
 * @author moqi On 11/23/20 11:10
 */
object A05GoingTheOtherWay {

  def main(args: Array[String]): Unit = {

    val l1 = List(1, 2, 3)
    val l2 = l1.map(x => x + 1)
    println(s"l2 = ${l2}")
    println()

    // 参考 https://www.geeksforgeeks.org/scala-flatmap-method/
    val l3 = l2.flatMap(y => List(y - 1, y, y + 1))
    println(s"l3 = ${l3}")
    println()

    // 参考 https://www.geeksforgeeks.org/scala-list-filter-method-with-example/
    val l4 = l3.filter(_ > 3)
    println(s"l4 = ${l4}")
    println()

  }

  def map[A, B](xs: List[A], f: A => B): List[B] =
    for (x <- xs) yield f(x)

  def flatMap[A, B](xs: List[A], f: A => List[B]): List[B] =
    for (x <- xs; y <- f(x)) yield y

  def filter[A](xs: List[A], p: A => Boolean): List[A] =
    for (x <- xs if p(x)) yield x

}
