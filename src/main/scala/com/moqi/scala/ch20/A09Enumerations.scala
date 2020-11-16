package com.moqi.scala.ch20

/**
 * 枚举
 *
 * @author moqi On 11/16/20 09:47
 */
object A09Enumerations {

  def main(args: Array[String]): Unit = {

    for (d <- Direction.values) print(d + " ")
    println()

    /**
     * 枚举的值从 0 开始编号，互相引用
     */
    println(s"Direction.East.id = ${Direction.East.id}")
    println(s"Direction(1) = ${Direction(1)}")

  }

}

/**
 * 路径依赖类型：Color 是路径而 Value 是依赖的类型
 */
object Color extends Enumeration {
  val Red = Value
  val Green = Value
  val Blue = Value
}

object Color2 extends Enumeration {
  val Red, Green, Blue = Value
}

object Direction extends Enumeration {
  val North, East, South, West = Value
}

object Direction2 extends Enumeration {
  val North = Value("North")
  val East = Value("East")
  val South = Value("South")
  val West = Value("West")
}