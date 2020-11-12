package com.moqi.scala.ch20

/**
 * 抽象的 Vals
 *
 * @author moqi On 11/12/20 16:48
 */
object A03AbstractVals {

  def main(args: Array[String]): Unit = {



  }

}

class A03Concrete extends Abstract {

  override type T = String

  override def transform(x: T): T = x + x

  /**
   * 抽象的 val 限制了它的合法实现
   * 任何实现都必须是一个 val 定义，而不能是 var 或者 def
   */
  override val initial: T = "hi"
  override var current: T = initial
}

/**
 * 重写抽象 val 和无参方法
 */
abstract class Fruit {
  val v: String
  def m: String
}

abstract class Apple extends Fruit {
  val v: String
  val m: String // 用 val 重写 def 是可以的
}

abstract class BadApple extends Fruit {
  // 错误：不能用 def 重写 val
  // def v: String
  def m: String
}