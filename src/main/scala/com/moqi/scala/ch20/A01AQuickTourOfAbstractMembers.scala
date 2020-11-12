package com.moqi.scala.ch20

/**
 * 抽象成员概览
 *
 * @author moqi On 11/12/20 14:19
 */
object A01AQuickTourOfAbstractMembers {

  def main(args: Array[String]): Unit = {

    val c1 = new Concrete
    println(s"c1.initial = ${c1.initial}")
    val t1 = c1.transform(" tom")
    println(s"t1 = ${t1}")

  }

}

trait Abstract {
  /**
   * 抽象类型
   */
  type T

  /**
   * 抽象方法
   */
  def transform(x: T): T

  val initial: T
  var current: T
}

/**
 * 实现 Abstract 特质需要填充每个抽象成员的定义
 */
class Concrete extends Abstract {

  override type T = String

  override def transform(x: String): String = x + x

  override val initial: String = "hi"
  override var current: String = initial
}