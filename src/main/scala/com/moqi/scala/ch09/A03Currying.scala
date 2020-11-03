package com.moqi.scala.ch09

/**
 * 柯里化
 *
 * @author moqi On 11/3/20 17:40
 */
object A03Currying {

  def main(args: Array[String]): Unit = {

    println(s"plainOldSum(1, 2) = ${plainOldSum(1, 2)}")
    println()

    println(s"curriedSum(1)(2) = ${curriedSum(1)(2)}")
    println()

    // 通过占位符表示法获取指向 curriedSum "第二个"函数的引用
    val onePlus = curriedSum(1)_
    println(s"onePlus(20) = ${onePlus(20)}")
    println()

    val twoPlus = curriedSum(2)_
    println(s"twoPlus(666) = ${twoPlus(666)}")
    println()

  }

  /**
   * 普通函数
   */
  def plainOldSum(x: Int, y: Int): Int = x + y

  /**
   * 柯里化函数
   */
  def curriedSum(x: Int)(y: Int): Int = x + y

}
