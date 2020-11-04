package com.moqi.scala.ch10

/**
 * 重写方法和字段
 *
 * @author moqi On 11/4/20 09:52
 */
abstract class A04AbstractElement {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

}

class A04ArrayElement(conts: Array[String]) extends A04AbstractElement {

  /**
   * 可以用字段覆盖抽象方法
   */
  override val contents: Array[String] = conts

}

object A04Test {

  def main(args: Array[String]): Unit = {

    val ae = new A04ArrayElement(Array("Hello", "World"))
    println(s"ae = ${ae}")
    println(s"ae.width = ${ae.width}")
    println()

    val e: A04AbstractElement = new A04ArrayElement(Array("Hello"))
    println(s"e = ${e}")
    println(s"e.height = ${e.height}")

  }

}