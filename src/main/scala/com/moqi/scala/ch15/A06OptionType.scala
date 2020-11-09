package com.moqi.scala.ch15

/**
 * Option 类型
 *
 * @author moqi On 11/9/20 11:41
 */
object A06OptionType {

  def main(args: Array[String]): Unit = {

    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
    println(s"capitals.get(France) = ${capitals.get("France")}")
    println(s"capitals.get(China) = ${capitals.get("China")}")
    println()

    println(s"show(capitals.get(France)) = ${show(capitals.get("France"))}")
    println(s"show(capitals.get(Japan)) = ${show(capitals.get("Japan"))}")
    println(s"show(capitals.get(China)) = ${show(capitals.get("China"))}")

  }

  /**
   * 将可选值解开最常见的方式是通过模式匹配
   */
  def show(x: Option[String]): String = x match {
    case Some(s) => s
    case None => "?"
  }
}
