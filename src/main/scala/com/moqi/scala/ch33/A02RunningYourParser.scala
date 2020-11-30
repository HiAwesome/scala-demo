package com.moqi.scala.ch33

/**
 * 运行你的解析器
 *
 * @author moqi On 11/30/20 16:16
 */
object A02RunningYourParser extends Arith {

  def main(args: Array[String]): Unit = {

    val args = Array("2 * (3 + 7)")
    println("input :" + args(0))
    println(parseAll(expr, args(0)))
    println()

  }

}
