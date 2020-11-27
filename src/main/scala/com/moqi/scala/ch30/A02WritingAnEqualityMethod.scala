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

    func3

  }

  private def func3: Unit = {
    val p = new Point2(1, 2)
    val set = mutable.HashSet(p)
    println(s"set contains p = ${set contains p}")
    p.x += 1
    println(s"set contains p = ${set contains p}")
    println(s"set.iterator contains p = ${set.iterator contains p}")
    println()
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

  /**
   * 加上重写 hashCode 方法
   * ## 是计算基本类型、引用类型和 null 的 hashCode 的简写方式
   * 另可参考：https://stackoverflow.com/a/9068566
   */
  override def hashCode(): Int = (x, y).##

}

/**
 * 用可变字段定义 equals
 */
class Point2(var x: Int, var y: Int) {

  override def equals(other: Any): Boolean = other match {
    case that: Point => this.x == that.x && this.y == that.y
    case _ => false
  }

  override def hashCode(): Int = (x, y).##

}