package com.moqi.scala.ch10

/**
 * 定义无参方法
 *
 * @author moqi On 11/4/20 09:24
 */
abstract class A02AbstractElement {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

}
