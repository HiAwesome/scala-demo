package com.moqi.scala.ch11

/**
 * 底类型：Null and Nothing
 *
 * @author moqi On 11/5/20 16:17
 */
object A03BottomTypes {

  def main(args: Array[String]): Unit = {

    println(s"divide(3, 2) = ${divide(3, 2)}")
    println(s"divide(3, 0) = ${divide(3, 0)}")

  }

  def error(message: String): Nothing = throw new RuntimeException(message)

  def divide(x: Int, y: Int): Int =
    if (y != 0) x / y
    else error("can't divide by zero")

}
