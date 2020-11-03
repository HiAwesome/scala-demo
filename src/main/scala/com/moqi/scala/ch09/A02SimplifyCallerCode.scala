package com.moqi.scala.ch09

/**
 * 简化调用方代码
 *
 * @author moqi On 11/3/20 17:30
 */
object A02SimplifyCallerCode {

  def main(args: Array[String]): Unit = {

    println(s"containsNeg(List(1, 2, 3, 4)) = ${containsNeg(List(1, 2, 3, 4))}")
    println(s"containsNeg(List(1, 2, -3, 4)) = ${containsNeg(List(1, 2, -3, 4))}")
    println()

    println(s"containsNeg2(Nil) = ${containsNeg2(Nil)}")
    println(s"containsNeg2(List(0, -1, -2)) = ${containsNeg2(List(0, -1, -2))}")
    println()

    println(s"containsOdd(List(1, 2, 3, 4)) = ${containsOdd(List(1, 2, 3, 4))}")
    println(s"containsOdd(List(2, 4)) = ${containsOdd(List(2, 4))}")
    println()

    println(s"containsOdd2(Nil) = ${containsOdd2(Nil)}")
    println(s"containsOdd2(List(0, -1)) = ${containsOdd2(List(0, -1))}")
    println()

  }

  def containsOdd2(nums: List[Int]): Boolean = nums.exists(_ % 2 == 1)

  def containsOdd(nums: List[Int]): Boolean = {
    var exists = false

    for (num <- nums; if !exists)
      if (num % 2 == 1)
        exists = true

    exists
  }

  def containsNeg2(nums: List[Int]): Boolean = nums.exists(_ < 0)

  def containsNeg(nums: List[Int]): Boolean = {
    var exists = false

    for (num <- nums; if !exists)
      if (num < 0)
        exists = true

    exists
  }

}
