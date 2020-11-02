package com.moqi.scala.ch07

/**
 * match 表达式
 *
 * @author moqi On 11/2/20 16:43
 */
object A05MatchExpression {

  def main(args: Array[String]): Unit = {

    func1(args)

    func2(args)

  }

  /**
   * 带有副作用的 match 表达式
   */
  private def func1(args: Array[String]): Unit = {
    val firstArg = if (args.length > 0) args(0) else ""

    firstArg match {
      case "salt" => println("pepper")
      case "chips" => println("salsa")
      case "eggs" => println("bacon")
      case _ => println("huh?")
    }
  }

  /**
   * 交出值的 match 表达式
   */
  private def func2(args: Array[String]): Unit = {
    val firstArg = if (args.length > 0) args(0) else ""

    val friend =
      firstArg match {
        case "salt" => "pepper"
        case "chips" => "salsa"
        case "eggs" => "bacon"
        case _ => "huh?"
      }

    println(s"friend = ${friend}")
  }


}
