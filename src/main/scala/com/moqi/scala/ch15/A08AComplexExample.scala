package com.moqi.scala.ch15

import com.moqi.scala.ch10.Element
import com.moqi.scala.ch10.Element.elem

/**
 * 一个复杂的例子
 *
 * @author moqi On 11/9/20 17:52
 */
object A08AComplexExample {

  def main(args: Array[String]): Unit = {

    val f = new ExprFormatter
    val e1 = BinOp("*", BinOp("/", Number(1), Number(2)), BinOp("+", Var("x"), Number(1)))
    val e2 = BinOp("+", BinOp("/", Var("x"), Number(2)), BinOp("/", Number(1.5), Var("x")))
    val e3 = BinOp("/", e1, e2)

    def show(e: Expr) = println(f.format(e) + "\n\n")

    for (e <- Array(e1, e2, e3))
      show(e)

  }

}

/**
 * 表达式格式化
 */
class ExprFormatter {

  /**
   * 包含优先级递增的操作符分组，优先级为每个 Array 元素的 Index
   */
  private val OpGroups =
    Array(
      Set("|", "||"),
      Set("&", "&&"),
      Set("^"),
      Set("==", "!="),
      Set("<", "<=", ">", ">="),
      Set("+", "-"),
      Set("*", "%")
    )

  /**
   * 从操作符到对应优先级的映射关系
   */
  private val precedence = {
    val orders =
      for {
        //i <- 0 until OpGroups.length
        i <- OpGroups.indices
        op <- OpGroups(i)
      } yield op -> i

    orders.toMap
  }

  // 最高优先级，被初始化为数组长度
  private val unaryPrecedence = OpGroups.length
  // 最低优先级，被初始化为 -1
  private val fractionPrecedence = -1

  private def format(e: Expr, enclPrec: Int): Element =
    e match {
      case Var(name) => elem(name)

      case Number(num) =>
        def stripDot(s: String): String =
          if (s endsWith ".0") s.substring(0, s.length - 2)
          else s

        elem(stripDot(num.toString))

      case UnOp(op, arg) => elem(op) beside format(arg, unaryPrecedence)

      case BinOp("/", left, right) =>
        val top = format(left, fractionPrecedence)
        val bot = format(right, fractionPrecedence)
        val line = elem('-', top.width max bot.width, 1)
        val frac = top above line above bot
        if (enclPrec != fractionPrecedence) frac
        else elem(" ") beside frac beside elem(" ")

      case BinOp(op, left, right) =>
        val opPrec = precedence(op)
        val l = format(left, opPrec)
        val r = format(right, opPrec + 1)
        val oper = l beside elem(" " + op + " ") beside r
        if (enclPrec <= opPrec) oper
        else elem("(") beside oper beside elem(")")
    }

  def format(e: Expr): Element = format(e, 0)

}