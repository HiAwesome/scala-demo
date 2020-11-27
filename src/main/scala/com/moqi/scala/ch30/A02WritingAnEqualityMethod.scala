package com.moqi.scala.ch30

import scala.collection.mutable

/**
 * 编写相等性方法
 *
 * @author moqi On 11/26/20 19:16
 */
object A02WritingAnEqualityMethod {

  def main(args: Array[String]): Unit = {

    func1

    func2

  }

  private def func2: Unit = {
    val p1, p2 = new Point(1, 2)
    val set = mutable.HashSet(p1)
    println(s"set contains p2 = ${set contains p2}")
    println()

    val p2a: Any = p2
    println(s"p1 equals p2a = ${p1 equals p2a}")
    println()
  }

  private def func1: Unit = {
    val p1, p2 = new Point(1, 2)
    val p3 = new Point(2, 3)
    println(s"p1 equals p2 = ${p1 equals p2}")
    println(s"p1 equals p3 = ${p1 equals p3}")
    println()
  }
}

class Point(val x: Int, val y: Int) {

  /**
   * 完全错误的 equals 定义
   */
  /*def equals(other: Point): Boolean =
    this.x == other.x && this.y == other.y*/

  /**
   * 这个定义要好一点，但仍不完美
   */
  override def equals(other: Any): Boolean = other match {
    case that: Point => this.x == that.x && this.y == that.y
    case _ => false
  }

}