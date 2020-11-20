package com.moqi.scala.ch22

import scala.collection.mutable.ListBuffer

/**
 * ListBuffer 类
 * ListBuffer 允许我们对列表的元素做累加，且追加和 toList 操作都只消耗（很短的）常量时间
 *
 * @author moqi On 11/20/20 15:20
 */
object A02TheListBufferClass {

  def main(args: Array[String]): Unit = {

    val xs = List(1, 2, 3, 4)
    val buf = new ListBuffer[Int]
    for (x <- xs) buf += x + 1
    val xsNew = buf.toList
    println(s"xsNew = ${xsNew}")

  }

  /**
   * 无法应用尾递归，所以对元素个数有限制
   */
  def incAll(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case x :: xs1 => x + 1 :: incAll(xs1)
  }

}
