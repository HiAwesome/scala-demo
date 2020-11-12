package com.moqi.scala.ch20

/**
 * 类型成员
 *
 * @author moqi On 11/12/20 16:46
 */
object A02TypeMembers {

  def main(args: Array[String]): Unit = {

    val c1 = new A02Concrete
    println(s"c1.initial = ${c1.initial}")
    val t1 = c1.transform(" tom")
    println(s"t1 = ${t1}")

  }

}

class A02Concrete extends Abstract {

  /**
   * 类型 T 被设定为 String 的别名
   */
  override type T = String

  override def transform(x: T): T = x + x

  override val initial: T = "hi"
  override var current: T = initial
}