package com.moqi.scala.ch24

/**
 * 字符串
 *
 * @author moqi On 11/24/20 16:41
 */
object A11Strings {

  def main(args: Array[String]): Unit = {

    val str = "hello"
    println(s"str.reverse = ${str.reverse}")
    println(s"str.map(_.toUpper) = ${str.map(_.toUpper)}")
    println(s"str drop 3 = ${str drop 3}")
    println(s"str slice (1, 4) = ${str slice(1, 4)}")
    println()

    val s: Seq[Char] = str
    println(s"s = ${s}")
    println()

  }

}
