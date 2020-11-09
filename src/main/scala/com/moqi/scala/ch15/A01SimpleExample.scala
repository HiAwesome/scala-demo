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
  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e // 双重取负
    case BinOp("+", e, Number(0)) => e // 加 0
    case BinOp("*", e, Number(1)) => e // 乘 1
    case _ => expr
  }

  /**
   * 带有空的"默认"样例的模式匹配
   * 如果去掉代码"case _ =>"，则对任何非 BinOp 的 expr 入参都会抛出 MatchError
   */
  def checkBinary(expr: Expr): String = expr match {
    case BinOp(op, left, right) => expr + " is a binary operation"
    case _ => "default branch"
  }

  private def func1: Unit = {
    val v = Var("x")
    println(s"v = ${v}")
    println(s"v.name = ${v.name}")
    println()

    val op = BinOp("+", Number(1), v)
    println(s"op = ${op}")
    println(s"op.left = ${op.left}")
    println()

    println(s"op.right == Var(x) = ${op.right == Var("x")}")
    println()

    val copyOp = op.copy(operator = "-")
    println(s"copyOp = ${copyOp}")
    println()
  }
}

/**
 * 将 Expr 设定为密封类
 * 密封类除了在同一个文件中定义的子类之外，不能添加新的子类
 */
sealed abstract class Expr

case class Var(name: String) extends Expr

case class Number(number: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
