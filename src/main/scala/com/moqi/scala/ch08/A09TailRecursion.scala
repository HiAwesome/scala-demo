package com.moqi.scala.ch08

import scala.annotation.tailrec

/**
 * 尾递归
 *
 * @author moqi On 11/3/20 16:11
 */
object A09TailRecursion {

  def main(args: Array[String]): Unit = {

    //boom(3)

    //bang(3)

    println(s"isOdd(10) = ${isOdd(10)}")
    println()

    nestedFun(3)

  }

  /**
   * 最后一步调用的是一个函数值，而不是发起调用的那个函数自己，也无法被优化为尾递归
   */
  val funValue = nestedFun _
  def nestedFun(x: Int): Unit =
    if (x != 0) {println(x); funValue(x - 1)}

  /**
   * 受限于 JVM 指令集，两个互相递归的函数无法优化为尾递归
   */
  def isEven(x: Int): Boolean = if (x == 0) true else isOdd(x - 1)
  def isOdd(x: Int): Boolean = if (x == 0) false else isEven(x - 1)

  /**
   * 不是尾递归的函数，会出现多个栈帧
   */
  def boom(x: Int): Int =
    if (x == 0) throw new Exception("boom")
    else boom(x - 1) + 1

  /**
   * 是尾递归的函数，只有一个栈帧
   * 可以用这个注解 tailrec 验证
   * 如果将这个注解放在不可以被优化为尾递归的函数上，会出现编译错误
   */
  @tailrec
  def bang(x: Int): Int =
    if (x == 0) throw new Exception("bang")
    else bang(x - 1)

}
