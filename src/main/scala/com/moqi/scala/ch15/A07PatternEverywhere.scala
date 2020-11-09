package com.moqi.scala.ch15

/**
 * 到处都是模式
 *
 * @author moqi On 11/9/20 11:52
 */
object A07PatternEverywhere {

  def main(args: Array[String]): Unit = {

    func1

  }


  /**
   * 变量定义中的模式
   * 在处理样例类时非常有用
   */
  private def func1: Unit = {
    val myTuple = (123, "abc")
    val (number, string) = myTuple
    println(s"number = ${number}")
    println(s"string = ${string}")
    println()

    val exp = BinOp("*", Number(5), Number(1))
    val BinOp(op, left, right) = exp
    println(s"op = ${op}")
    println(s"left = ${left}")
    println(s"right = ${right}")
  }
}
