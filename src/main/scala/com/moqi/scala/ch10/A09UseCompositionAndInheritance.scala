package com.moqi.scala.ch10

/**
 * 使用组合和继承
 *
 * @author moqi On 11/5/20 09:17
 */
object A09UseCompositionAndInheritance {

  def main(args: Array[String]): Unit = {


  }

}

abstract class A09AbstractElement {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

}

class A09ArrayElement(private val conts: Array[String]) extends A09AbstractElement {

  override val contents: Array[String] = conts

}

/**
 * 将 A09LineElement 定义为 A09AbstractElement 的直接子类
 */
class A09LineElement(s: String) extends A09AbstractElement {

  val contents = Array(s)

  override def width: Int = s.length

  override def height: Int = 1

}