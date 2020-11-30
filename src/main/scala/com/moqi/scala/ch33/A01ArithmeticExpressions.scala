package com.moqi.scala.ch33

import scala.util.parsing.combinator._

/**
 * 算术表达式
 *
 * @author moqi On 11/30/20 16:04
 */
object A01ArithmeticExpressions {
  def main(args: Array[String]): Unit = {


  }

}

/**
 * 算术表达式解析器
 */
class Arith extends JavaTokenParsers {

  def expr: Parser[Any] = term ~ rep("+" ~ term | "-" ~ term)

  def term: Parser[Any] = factor ~ rep("*" ~ factor | "/" ~ factor)

  def factor: Parser[Any] = floatingPointNumber | "(" ~ expr ~ ")"
}