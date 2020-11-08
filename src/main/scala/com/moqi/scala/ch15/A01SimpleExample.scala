package com.moqi.scala.ch15

/**
 * 一个简单的例子
 *
 * @author moqi On 11/8/20 15:32
 */
object A01SimpleExample {

  def main(args: Array[String]): Unit = {

    func1

  }

  /**
   * 用到模式匹配的 simplifyTop 函数
   * 选择器 match {可选分支}
   */
  def simplifyTop(expr: A01Expr): A01Expr = expr match {
    case A01UnOp("-", A01UnOp("-", e)) => e // 双重取负
    case A01BinOp("+", e, A01Number(0)) => e // 加 0
    case A01BinOp("*", e, A01Number(1)) => e // 乘 1
    case _ => expr
  }

  /**
   * 带有空的"默认"样例的模式匹配
   * 如果去掉代码"case _ =>"，则对任何非 BinOp 的 expr 入参都会抛出 MatchError
   */
  def emptyMatch(expr: A01Expr): Unit = expr match {
    case A01BinOp(op, left, right) => println(expr + " is a binary operation")
    case _ =>
  }

  private def func1: Unit = {
    val v = A01Var("x")
    println(s"v = ${v}")
    println(s"v.name = ${v.name}")
    println()

    val op = A01BinOp("+", A01Number(1), v)
    println(s"op = ${op}")
    println(s"op.left = ${op.left}")
    println()

    println(s"op.right == Var(x) = ${op.right == A01Var("x")}")
    println()

    val copyOp = op.copy(operator = "-")
    println(s"copyOp = ${copyOp}")
    println()
  }
}

abstract class A01Expr

case class A01Var(name: String) extends A01Expr

case class A01Number(number: Double) extends A01Expr

case class A01UnOp(operator: String, arg: A01Expr) extends A01Expr

case class A01BinOp(operator: String, left: A01Expr, right: A01Expr) extends A01Expr
