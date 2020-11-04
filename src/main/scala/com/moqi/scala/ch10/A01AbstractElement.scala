package com.moqi.scala.ch10

/**
 * 抽象类
 *
 * @author moqi On 11/4/20 09:17
 */
abstract class A01AbstractElement {

  /**
   * 不需要加上前缀 abstract 修饰符，没有实现的方法默认为抽象方法
   */
  def contents: Array[String]

}
