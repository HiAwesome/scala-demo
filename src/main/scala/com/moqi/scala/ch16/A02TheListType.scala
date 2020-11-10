package com.moqi.scala.ch16

/**
 * List 类型和泛型
 *
 * @author moqi On 11/10/20 10:26
 */
object A02TheListType {

  def main(args: Array[String]): Unit = {

    val fruit: List[String] = List("apple", "orange", "pears")
    val nums: List[Int] = List(1, 2, 3, 4)
    val diag3: List[List[Int]] =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )
    val empty: List[Nothing] = List()

    println(s"fruit = ${fruit}")
    println(s"nums = ${nums}")
    println(s"diag3 = ${diag3}")
    println(s"empty = ${empty}")

  }

}
