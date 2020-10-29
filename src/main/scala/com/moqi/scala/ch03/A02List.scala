package com.moqi.scala.ch03

/**
 * 使用列表
 *
 * @author moqi On 10/29/20 11:29
 */
object A02List {

  def main(args: Array[String]): Unit = {

    oneTwoThree

    oneTwoThreeFour

    oneTwoThree2

    oneTwoThree3

  }

  private def oneTwoThree3 = {
    // 之所以末尾放一个 Nil，是因为 :: 是 List 类上定义的方法
    // 如果不带 Nil，三个 Int 并不具有 :: 方法
    val oneTwoThree3 = 1 :: 2 :: 3 :: Nil
    println(s"oneTwoThree3 = ${oneTwoThree3}")
  }

  private def oneTwoThree2 = {
    val twoThree = List(2, 3)
    val oneTwoThree2 = 1 :: twoThree
    println(s"oneTwoThree2 = ${oneTwoThree2}")
    println()
  }

  private def oneTwoThreeFour = {
    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val oneTwoThreeFour = oneTwo ::: threeFour
    println(oneTwo + " and" + threeFour + " were not mutated.")
    println("Thus, " + oneTwoThreeFour + " is a new list.")
    println()
  }

  private def oneTwoThree = {
    val oneTwoThree = List(1, 2, 3)
    println(s"oneTwoThree = ${oneTwoThree}")
    println()
  }

}
