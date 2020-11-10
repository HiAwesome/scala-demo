package com.moqi.scala.ch16

/**
 * 列表的基本操作
 *
 * @author moqi On 11/10/20 10:35
 */
object A04BasicOperationsOnLists {

  def main(args: Array[String]): Unit = {

    val fruit = List("apple", "orange", "pears")
    val diag3 =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )
    val empty = List()

    println(s"empty.isEmpty = ${empty.isEmpty}")
    println(s"fruit.isEmpty = ${fruit.isEmpty}")
    println(s"fruit.head = ${fruit.head}")
    // 第二个
    println(s"fruit.tail.head = ${fruit.tail.head}")
    println(s"diag3.head = ${diag3.head}")
    println()

    val sort = List(9, 3, 2, 5, 0, 100)
    println(s"sort = ${sort}")
    println(s"isort(sort) = ${isort(sort)}")
  }

  /**
   * 递归方式的插入排序
   */
  def isort(xs: List[Int]): List[Int] =
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))

  def insert(x: Int, xs: List[Int]): scala.List[Int] =
    if (xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)


}
