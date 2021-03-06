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

    func4

    func5

    func6

    func7

  }

  private def func7: Unit = {
    val p = new Point(1, 2)
    val cp = new ColoredPoint(1, 2, Color.Indigo)
    val pAnon = new Point(1, 1) {
      override val y = 2
    }
    val list = List(p)
    println(s"list contains p = ${list contains p}")
    println(s"list contains cp = ${list contains cp}")
    println(s"list contains pAnon = ${list contains pAnon}")
    println()
  }

  private def func6: Unit = {
    val p = new Point(1, 2)
    val pAnon = new Point(1, 1) {
      override val y = 2
    }
    println(s"p == pAnon = ${p == pAnon}")
    println()
  }

  private def func5: Unit = {
    val p = new Point(1, 2)
    val redP = new ColoredPoint(1, 2, Color.Red)
    val blueP = new ColoredPoint(1, 2, Color.Blue)
    println(s"redP == p = ${redP == p}")
    println(s"blueP == p = ${blueP == p}")
    println(s"redP == blueP = ${redP == blueP}")
    println()
  }

  private def func4: Unit = {
    val p = new Point(1, 2)
    val cp = new ColoredPoint(1, 2, Color.Red)
    println(s"p equals cp = ${p equals cp}")
    println(s"cp equals p = ${cp equals p}")
    println()

    println(s"mutable.HashSet[Point](p) contains cp = ${mutable.HashSet[Point](p) contains cp}")
    println(s"mutable.HashSet[Point](cp) contains p = ${mutable.HashSet[Point](cp) contains p}")
    println()
  }

  private def func3: Unit = {
    val p = new VarPoint(1, 2)
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

/**
 * 解决子类 equals 传递性问题
 * 最终带 canEqual 方法的实现
 */
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
    case that: Point => (that canEqual this) && this.x == that.x && this.y == that.y
    case _ => false
  }

  /**
   * 加上重写 hashCode 方法
   * ## 是计算基本类型、引用类型和 null 的 hashCode 的简写方式
   * 另可参考：https://stackoverflow.com/a/9068566
   */
  override def hashCode(): Int = (x, y).##

  def canEqual(other: Any): Boolean = other.isInstanceOf[Point]
}

/**
 * 用可变字段定义 equals
 */
class VarPoint(var x: Int, var y: Int) {

  override def equals(other: Any): Boolean = other match {
    case that: Point => this.x == that.x && this.y == that.y
    case _ => false
  }

  override def hashCode(): Int = (x, y).##

}

object Color extends Enumeration {
  val Red, Orange, Yellow, Green, Blue, Indigo, Violet = Value
}

/**
 * 问题：equals 不对称
 * 解决方案 v1：更笼统化，问题是：equals 不是可传递的
 * 解决方案 v2：更严格化，是技术上可行但并不令人满意的 equals 方法
 */
class ColoredPoint(x: Int, y: Int, val color: Color.Value)
  extends Point(x, y) {

  override def equals(other: Any): Boolean = other match {
    case that: ColoredPoint => (that canEqual this) && this.color == that.color && super.equals(that)
    case _ => false
  }

  override def canEqual(other: Any): Boolean = other.isInstanceOf[ColoredPoint]
}