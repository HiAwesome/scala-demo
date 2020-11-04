package com.moqi.scala.ch10

/**
 * 声明 final 成员
 * 被 final 修饰的方法不可以被重写，被 final 修饰的类不可以被继承
 *
 * @author moqi On 11/4/20 19:28
 */
object A08DeclareFinalMembers {

}

abstract class A08AbstractElement {

  def demo(): Unit = println("Element's implementation invoked")

}

class A08ArrayElement(private val conts: Array[String]) extends A08AbstractElement {

  final override def demo(): Unit = println("ArrayElement's implementation invoked")

}

final class A08LineElement(s: String) extends A08ArrayElement(Array(s)) {


  // override def demo(): Unit = println("LineElement's implementation invoked")

}
