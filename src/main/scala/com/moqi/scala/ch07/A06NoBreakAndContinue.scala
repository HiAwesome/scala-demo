package com.moqi.scala.ch07

import java.io.{BufferedReader, InputStreamReader}

import scala.annotation.tailrec
import scala.util.control.Breaks.{break, breakable}

/**
 * 没有 break 和 continue 的日子
 *
 * @author moqi On 11/2/20 17:50
 */
object A06NoBreakAndContinue {

  val scalaArray: Array[String] = Array.apply("1", "2", "-", "2-2", "a.scala")

  def main(args: Array[String]): Unit = {

    println(s"func1(scalaArray) = ${func1(scalaArray)}")

    println(s"searchFrom(0) = ${searchFrom(0)}")

    breakAbleTest

  }

  def breakAbleTest = {
    val in = new BufferedReader(new InputStreamReader(System.in))

    breakable {
      while (true) {
        println("input something or blank to exit: ")
        val str: String = in.readLine()
        if (str != "") println(s"str = ${str}")
        else break
      }
    }
  }

  @tailrec
  def searchFrom(i: Int): Int = {
    if (i >= scalaArray.length) -1
    else if (scalaArray(i).startsWith("-")) searchFrom(i + 1)
    else if (scalaArray(i).endsWith(".scala")) i + 1
    else searchFrom(i + 1)
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
