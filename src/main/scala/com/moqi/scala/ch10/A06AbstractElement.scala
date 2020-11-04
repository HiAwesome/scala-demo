package com.moqi.scala.ch10

/**
 * 调用超类构造方法
 *
 * @author moqi On 11/4/20 10:06
 */
abstract class A06AbstractElement {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

}

class A06ArrayElement(private val conts: Array[String]) extends A06AbstractElement {

  override val contents: Array[String] = conts

}

/**
 * 调用超类构造方法, 将如餐放在超类括号里
 */
class A06LineElement(s: String) extends A06ArrayElement(Array(s)) {

  override def width: Int = s.length

  override def height: Int = 1

}

object A06Test {

  def main(args: Array[String]): Unit = {

    val ae: A06ArrayElement = new A06LineElement("Hello")
    println(s"ae.contents = ${ae.contents.mkString("Array(", ", ", ")")}")
    println(s"ae.width = ${ae.width}")
    println(s"ae.height = ${ae.height}")

  }

}