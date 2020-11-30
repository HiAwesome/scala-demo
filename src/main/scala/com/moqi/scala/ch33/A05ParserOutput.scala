package com.moqi.scala.ch33

import java.io.FileReader

import scala.util.parsing.combinator.JavaTokenParsers

/**
 * 解析器输出
 *
 * @author moqi On 11/30/20 16:33
 */
object A05ParserOutput extends JSON1 {

  def main(args: Array[String]): Unit = {

    val args = Array("/Users/moqi/Code/scala-demo/src/main/resources/address-book.json")
    val reader = new FileReader(args(0))
    println(parseAll(value, reader))
    println()

  }

}

/**
 * 一个完整的返回有意义结果的 JSON 解析器
 */
class JSON1 extends JavaTokenParsers {

  def obj: Parser[Map[String, Any]] =
    "{" ~> repsep(member, ",") <~ "}" ^^ (Map() ++ _)

  def arr: Parser[List[Any]] =
    "[" ~> repsep(value, ",") <~ "]"

  def member: Parser[(String, Any)] =
    stringLiteral ~ ":" ~ value ^^ { case name ~ ":" ~ value => (name, value) }

  def value: Parser[Any] = (
    obj
      | arr
      | stringLiteral
      | floatingPointNumber ^^ (_.toDouble)
      | "null" ^^ (x => null)
      | "true" ^^ (x => true)
      | "false" ^^ (x => false)
    )
}
