package com.moqi.scala.ch15

import math.{E, Pi}

/**
 * 模式的种类
 *
 * @author moqi On 11/8/20 16:10
 */
object A02TypesOfPatterns {

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3


  }

  private def func3: Unit = {
    // 大写字母开头的 case Pi 是常量
    val res1 = E match {
      case Pi => "strange math? Pi = " + Pi
      case _ => "Default OK"
    }
    println(s"res1 = ${res1}")

    val pi = math.Pi
    // 小写字母开头的 case pi 是变量
    val res2 = E match {
      // 这里 IDEA 会提示 Declaration is never used，因此可以简写为 case _, 所以事实上永远走不到下面的分支
      case pi => "strange math? Pi = " + Pi
      case _ => "Default OK"
    }
    println(s"res2 = ${res2}")

    // 反引号修饰的小写字母开头的 case pi 是常量
    val res3 = E match {
      case `pi` => "strange math? Pi = " + Pi
      case _ => "Default OK"
    }
    println(s"res3 = ${res3}")
  }

  private def func2: Unit = {
    println(s"startWithZero(0) = ${startWithZero(0)}")
    println(s"startWithZero(100) = ${startWithZero(100)}")
    println()
  }

  private def func1: Unit = {
    println(s"describe(5) = ${describe(5)}")
    println(s"describe(true) = ${describe(true)}")
    println(s"describe(hello) = ${describe("hello")}")
    println(s"describe(Nil) = ${describe(Nil)}")
    println(s"describe(List(1, 2, 3)) = ${describe(List(1, 2, 3))}")
    println()
  }

  /**
   * 通配模式 1
   */
  def checkBinary1(expr: Expr): Unit = expr match {
    case BinOp(op, left, right) => println(expr + " is a binary operation")
    case _ =>
  }

  /**
   * 通配模式 2
   * 使用 _ 来忽略不关心的局部，具体使用是 _, _, _
   */
  def checkBinary2(expr: Expr): Unit = expr match {
    case BinOp(_, _, _) => println(expr + " is a binary operation")
    case _ => println("It's something else.")
  }

  /**
   * 常量模式
   */
  def describe(x: Any): String = x match {
    case 5 => "file"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }

  /**
   * 变量模式
   */
  def startWithZero(expr: Any) = expr match {
    case 0 => "zero"
    case somethingElse => "not zero: " + somethingElse
  }

  /**
   * 构造方法匹配
   * 这个示例是一个长度只有一行但深度有三层的模式
   */
  def deepMatch(expr: Expr) = expr match {
    case BinOp("+", e, Number(0)) => println("a deep match")
    case _ =>
  }

}
