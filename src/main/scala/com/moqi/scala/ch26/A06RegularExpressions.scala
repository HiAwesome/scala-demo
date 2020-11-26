package com.moqi.scala.ch26

import util.matching.Regex

/**
 * 正则表达式
 *
 * @author moqi On 11/26/20 10:30
 */
object A06RegularExpressions {

  private val textString = "pi = 3.1415926"

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

    func4

  }


  private def func4: Unit = {
    val decimal4 = """(-)?(\d+)(\.\d*)?""".r
    val decimal4(sign, integerPart, decimalPart) = "-1.23"
    println(s"sign = ${sign}, integerPart = ${integerPart},  decimalPart = ${decimalPart}")
    val decimal4(sign1, integerPart1, decimalPart1) = "1.0"
    println(s"sign1 = ${sign1}, integerPart1 = ${integerPart1},  decimalPart1 = ${decimalPart1}")
    println()

    val input = "for -1.0 to 99 by 3"
    for (decimal4(s, i, d) <- decimal4 findAllIn input)
      println("sign: " + s + ", integer: " + i + ", decimal: " + d)
    println()
  }

  private def func3: Unit = {
    val decimal3 = """(-)?(\d+)(\.\d*)?""".r
    val input = "for -1.0 to 99 by 3"
    for (s <- decimal3 findAllIn (input))
      println(s"s = ${s}")
    println(s"decimal3 findFirstIn input = ${decimal3 findFirstIn input}")
    println(s"decimal3 findPrefixOf input = ${decimal3 findPrefixOf input}")
    println()
  }

  private def func2: Unit = {
    val decimal1 = new Regex("""(-)?(\d+)(\.\d*)?""")
    val decimal2 = """(-)?(\d+)(\.\d*)?""".r
    println(s"decimal1.findAllIn(textString).mkString = ${decimal1.findAllIn(textString).mkString}")
    println(s"decimal2.findAllIn(textString).mkString = ${decimal2.findAllIn(textString).mkString}")
    println()
  }

  private def func1: Unit = {
    val decimal = new Regex("(-)?(\\d+)(\\.\\d*)?")
    val r1 = decimal.findAllIn(textString)
    println(s"r1.mkString = ${r1.mkString}")
    println()
  }
}
