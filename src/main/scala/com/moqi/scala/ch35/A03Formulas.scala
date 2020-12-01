package com.moqi.scala.ch35

/**
 * 公式
 *
 * @author moqi On 12/1/20 09:33
 */
object A03Formulas {

}

/**
 * 用于表示公式的类
 */
trait Formula

/**
 * 单元格坐标，例如 A3
 */
case class Coord(row: Int, column: Int) extends Formula {
  override def toString = ('A' + column).toChar.toString + row
}

/**
 * 单元格区间，例如 A3:B17
 */
case class Range(c1: Coord, c2: Coord) extends Formula {
  override def toString = c1.toString + ":" + c2.toString
}

/**
 * 浮点数，例如 3.1415
 */
case class Number(value: Double) extends Formula {
  override def toString = value.toString
}

/**
 * 文本标签，例如 Deprecation
 */
case class Textual(value: String) extends Formula {
  override def toString = value
}

/**
 * 函数应用，例如 sum(A1, A2)
 */
case class Application(function: String,
                       arguments: List[Formula]) extends Formula {

  override def toString =
    function + arguments.mkString("(", ",", ")")
}

object Empty extends Textual("")