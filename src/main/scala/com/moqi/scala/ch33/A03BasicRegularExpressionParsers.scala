package com.moqi.scala.ch33

import scala.util.parsing.combinator.RegexParsers

/**
 * 基本的正则表达式解析器
 *
 * @author moqi On 11/30/20 16:22
 */
object A03BasicRegularExpressionParsers extends RegexParsers {

  /**
   * 针对 Java 标识符的正则表达式解析器
   */
  val ident: Parser[String] = """[a-zA-Z_]\w*""".r

}
