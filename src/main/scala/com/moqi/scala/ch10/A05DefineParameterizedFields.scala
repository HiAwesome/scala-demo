package com.moqi.scala.ch10

/**
 * 定义参数化字段
 *
 * @author moqi On 11/4/20 09:56
 */
abstract class A05AbstractElement {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

}

/**
 * 定义参数化字段, 还可以增加修饰符
 */
class A05ArrayElement(private val conts: Array[String]) extends A05AbstractElement {

  override val contents: Array[String] = conts

}

class A05Cat {
  val dangerous = false
}

class A05Tiger(override val dangerous: Boolean, private var age: Int) extends A05Cat

object A05DefineParameterizedFields {

  def main(args: Array[String]): Unit = {

    val ae = new A05ArrayElement(Array("Hello", "World"))
    println(s"ae = ${ae}")
    println(s"ae.width = ${ae.width}")
    println()

    val e: A05AbstractElement = new A05ArrayElement(Array("Hello"))
    println(s"e = ${e}")
    println(s"e.height = ${e.height}")
    println()

    // age 是私有属性，所以无法访问
    val tiger = new A05Tiger(true, 18)
    println(s"tiger.dangerous = ${tiger.dangerous}")

  }

}