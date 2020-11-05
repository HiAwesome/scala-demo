package com.moqi.scala.ch11

/**
 * Scala 类继承关系
 *
 * @author moqi On 11/5/20 16:14
 */
object A01ClassInheritance {

  def main(args: Array[String]): Unit = {

    func1

    println(s"42 max 43 = ${42 max 43}")
    println(s"42 min 43 = ${42 min 43}")
    println(s"1 until 5 = ${1 until 5}")
    println(s"1 to 5 = ${1 to 5}")
    println(s"3.abs = ${3.abs}")
    println(s"(-100).abs = ${(-100).abs}")

  }

  private def func1: Unit = {
    println(s"42.toString = ${42.toString}")
    println(s"42.hashCode = ${42.hashCode}")
    println(s"42 equals 42 = ${42 equals 42}")
    println()
  }
}
