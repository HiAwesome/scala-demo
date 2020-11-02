package com.moqi.scala.ch07

/**
 * match 表达式
 *
 * @author moqi On 11/2/20 16:43
 */
object A05MatchExpression {

  def main(args: Array[String]): Unit = {

    func1(args)

  }

  private def func1(args: Array[String]): Unit = {
    val firstArg = if (args.length > 0) args(0) else ""

    firstArg match {
      case "salt" => println("pepper")
      case "chips" => println("salsa")
      case "eggs" => println("bacon")
      case _ => println("huh?")
    }
  }
}
