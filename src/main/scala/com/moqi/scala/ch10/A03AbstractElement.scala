package com.moqi.scala.ch10

/**
 * 扩展类
 *
 * @author moqi On 11/4/20 09:41
 */
abstract class A03AbstractElement {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

}

class A03ArrayElement(conts: Array[String]) extends A03AbstractElement {



  override def contents: Array[String] = conts

}

object A03Test {

  def main(args: Array[String]): Unit = {

    val ae = new A03ArrayElement(Array("Hello", "World"))
    println(s"ae = ${ae}")
    println(s"ae.width = ${ae.width}")
    println()

    val e: A03AbstractElement = new A03ArrayElement(Array("Hello"))
    println(s"e = ${e}")
    println(s"e.height = ${e.height}")

  }

}