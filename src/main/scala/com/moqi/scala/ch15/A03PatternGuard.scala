package com.moqi.scala.ch15

/**
 * 模式守卫
 *
 * @author moqi On 11/9/20 10:28
 */
object A03PatternGuard {

  def main(args: Array[String]): Unit = {

    println(s"simplifyAdd(BinOp(+, 10, 10)) = ${simplifyAdd(BinOp("+", Number(10), Number(10)))}")
    println(s"practice(100) = ${practice(100)}")
    println(s"practice(abcdefg) = ${practice("abcdefg")}")
    println(s"practice(-100) = ${practice(-100)}")

  }

  /**
   * 带有模式守卫的 match 表达式，即 if x == y
   * 模式守卫通常会引用到模式中的变量，可以是任意的布尔值表达式
   */
  def simplifyAdd(e: Expr): Expr = e match {
    case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
    case _ => e
  }

  /**
   * 练习模式守卫
   */
  def practice(x: Any): Int = x match {
    // 只匹配正整数
    case n: Int if n > 0 => n
    // 只匹配以字母 a 开头的字符串
    case s: String if s(0) == 'a' => s.length
    case _ => -1
  }

}
