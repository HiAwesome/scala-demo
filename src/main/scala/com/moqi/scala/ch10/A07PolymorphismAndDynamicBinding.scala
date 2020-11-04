package com.moqi.scala.ch10

/**
 * 多态和动态绑定
 *
 * @author moqi On 11/4/20 10:19
 */
object A07PolymorphismAndDynamicBinding {


}

abstract class A07AbstractElement {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

}

class UniformElement(
                      ch: Char,
                      override val width: Int,
                      override val height: Int,
                    ) extends A07AbstractElement {

  private val line = ch.toString * width

  override def contents: Array[String] = Array.fill(height)(line)

}