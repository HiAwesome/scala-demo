package com.moqi.scala.ch15

/**
 * 模式的种类
 *
 * @author moqi On 11/8/20 16:10
 */
object A02TypesOfPatterns {

  def main(args: Array[String]): Unit = {


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

}
