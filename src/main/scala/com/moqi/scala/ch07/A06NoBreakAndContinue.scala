package com.moqi.scala.ch07

/**
 * 没有 break 和 continue 的日子
 *
 * @author moqi On 11/2/20 17:50
 */
object A06NoBreakAndContinue {

  val scalaArray: Array[String] = Array.apply("1", "2", "-", "2-2", "a.scala")

  def main(args: Array[String]): Unit = {

    println(s"func1(scalaArray) = ${func1(scalaArray)}")

  }

  def func1(args: Array[String]): Int = {
    var i = 0
    var foundIt = false

    while (i < args.length && !foundIt) {
      if (!args(i).startsWith("-")) {
        if (args(i).endsWith(".scala")) {
          foundIt = true
        }
      }

      i += 1
    }

    i
  }

}
