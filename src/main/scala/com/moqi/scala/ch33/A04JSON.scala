package com.moqi.scala.ch33

import java.io.FileReader

import util.parsing.combinator._

/**
 * 另一个示例：JSON
 *
 * @author moqi On 11/30/20 16:26
 */
object A04JSON extends JSON {

  def main(args: Array[String]): Unit = {

    val args = Array("/Users/moqi/Code/scala-demo/src/main/resources/address-book.json")
    val reader = new FileReader(args(0))
    println(parseAll(value, reader))
    println()

  }

}

/**
 * 一个简单的 JSON 解析器
 */
class JSON extends JavaTokenParsers {

  def value: Parser[Any] = obj | arr | stringLiteral | floatingPointNumber | "null" | "true" | "false"

  def obj: Parser[Any] = "{" ~ repsep(member, ",") ~ "}"

  def arr: Parser[Any] = "[" ~ repsep(value, ",") ~ "]"

  def member: Parser[Any] = stringLiteral ~ ":" ~ value

}