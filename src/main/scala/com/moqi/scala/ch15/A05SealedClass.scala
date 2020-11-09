package com.moqi.scala.ch15

/**
 * 密封类
 *
 * @author moqi On 11/9/20 11:04
 */
object A05SealedClass {

  def main(args: Array[String]): Unit = {

    println()

  }

  /**
   * 测试漏掉一些 case 的匹配模式
   */
  def describe(expr: Expr): String = expr match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
    case _ => throw new RuntimeException // 不应该发生
  }

}

/**
 * Illegal inheritance from sealed class 'Expr'
 */
// case class ExprSubClass(name: String) extends Expr
