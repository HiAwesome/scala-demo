package com.moqi.scala.ch20

import scala.annotation.tailrec

/**
 * 初始化抽象的 val
 *
 * @author moqi On 11/13/20 10:11
 */
object A05InitializingAbstractVals {

  def main(args: Array[String]): Unit = {

    // func1

    // func2

    func3

  }

  /**
   * 匿名类表达式中预初始化的字段
   */
  private def func3: Unit = {
    val x = 2
    val r3 = new {
      override val numberArg: Int = 1 * x
      override val denominatorArg: Int = 2 * x
    } with RationalTrait
    println(s"r3 = ${r3}")
    println()
  }

  /**
   * 类参数和抽象字段的初始化顺序不同
   * 运行时会发生 Exception in thread "main" java.lang.IllegalArgumentException: requirement failed
   * 因为 require(denominatorArg > 0) 而特质初始化过程中两个值都是 Int 的默认值 0
   */
  private def func2: Unit = {
    val x = 2
    val r2 = new RationalTrait {
      override val numberArg: Int = 1 * x
      override val denominatorArg: Int = 2 * x
    }
    println(s"r2 = ${r2}")
    println()
  }

  private def func1: Unit = {
    // 混入了特质并由定义体定义的匿名类的实例
    val r1 = new RationalTrait {
      override val numberArg: Int = 1
      override val denominatorArg: Int = 2
    }
    println(s"r1 = ${r1}")
    println()
  }
}

/**
 * 有理数的特质
 */
trait RationalTrait {
  val numberArg: Int
  val denominatorArg: Int

  require(denominatorArg > 0)

  private val g = gcd(numberArg, denominatorArg)

  val number = numberArg / g
  val denominator = denominatorArg / g

  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString: String = number + "/" + denominator
}