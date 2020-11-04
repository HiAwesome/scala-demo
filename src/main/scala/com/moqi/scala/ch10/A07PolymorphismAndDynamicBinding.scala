package com.moqi.scala.ch10

/**
 * 多态和动态绑定
 *
 * @author moqi On 11/4/20 10:19
 */
object A07PolymorphismAndDynamicBinding {

  def main(args: Array[String]): Unit = {

    val e1: A07AbstractElement = new A07ArrayElement(Array("Hello", "world"))
    val ae: A07ArrayElement = new A07LineElement("Hello")
    val e2: A07AbstractElement = ae
    val e3: A07AbstractElement = new A07UniformElement('x', 2, 3)

    invokeDemo(new A07ArrayElement(Array()))
    invokeDemo(new A07LineElement(""))
    invokeDemo(new A07UniformElement('x', 2, 3))

  }

  def invokeDemo(e: A07AbstractElement): Unit = e.demo()

}

abstract class A07AbstractElement {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  def demo(): Unit = println("Element's implementation invoked")

}

class A07ArrayElement(private val conts: Array[String]) extends A07AbstractElement {

  override val contents: Array[String] = conts

  override def demo(): Unit = println("ArrayElement's implementation invoked")

}

class A07LineElement(s: String) extends A07ArrayElement(Array(s)) {

  override def width: Int = s.length

  override def height: Int = 1

  override def demo(): Unit = println("LineElement's implementation invoked")

}

/**
 * 未覆盖 A07AbstractElement 的 demo 方法
 */
class A07UniformElement(
                         ch: Char,
                         override val width: Int,
                         override val height: Int,
                       ) extends A07AbstractElement {

  private val line = ch.toString * width

  override def contents: Array[String] = Array.fill(height)(line)

}