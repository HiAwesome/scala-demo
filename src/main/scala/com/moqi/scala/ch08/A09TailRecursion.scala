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

    bang(3)

  }

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
