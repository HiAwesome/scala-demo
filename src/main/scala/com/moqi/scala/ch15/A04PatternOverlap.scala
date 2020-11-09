package com.moqi.scala.ch15

/**
 * 模式重叠
 *
 * @author moqi On 11/9/20 10:41
 */
object A04PatternOverlap {

  def main(args: Array[String]): Unit = {

    println(s"${simplifyAll(UnOp("-", UnOp("-", Number(100))))}")
    println(s"${simplifyAll(BinOp("+", Number(200), Number(0)))}")
    println(s"${simplifyAll(BinOp("*", Number(300), Number(1)))}")
    println(s"Number(400) = ${Number(400)}")
    println()

  }

  /**
   * 样例类顺序敏感的 match 表达式
   */
  def simplifyAll(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => simplifyAll(e) // - 是自己的取反
    case BinOp("+", e, Number(0)) => simplifyAll(e) // 0 是 + 的中性元素
    case BinOp("*", e, Number(1)) => simplifyAll(e) // 1 是 * 的中性元素
    case UnOp(op, e) => UnOp(op, simplifyAll(e))
    case BinOp(op, l, r) => BinOp(op, simplifyAll(l), simplifyAll(r))
    case _ => expr
  }

  /**
   * 第二个分支永远不会被匹配到，这个匹配是完全没有意义的
   */
  def simplifyBad(expr: Expr): Expr = expr match {
    case UnOp(op, e) => UnOp(op, simplifyBad(e))
    case UnOp("-", UnOp("-", e)) => e
  }

}
