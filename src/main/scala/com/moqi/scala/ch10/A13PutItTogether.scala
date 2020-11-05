package com.moqi.scala.ch10

import com.moqi.scala.ch10.A13AbstractElement._

/**
 * 放在一起
 *
 * @author moqi On 12/5/20 10:12
 */
object A13IncreaseAndWiden {

  def main(args: Array[String]): Unit = {

    val column1 = elem("hello") above elem("***")
    val column2 = elem("***") above elem("world")
    println(column1 beside column2)
    println()

    for (nSides <- Array(6, 11, 17)) {
      println(s"nSides = $nSides")
      println(spiral(nSides, 0))
      println()
    }

  }

  val space = elem(" ")
  val corner = elem("+")

  def spiral(nEdges: Int, direction: Int): A13AbstractElement = {
    if (nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges - 1, (direction + 3) % 4)

      def verticalBar = elem('|', 1, sp.height)

      def horizontalBar = elem('-', sp.width, 1)

      if (direction == 0)
        (corner beside horizontalBar) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if (direction == 2)
        (space beside sp) above (horizontalBar beside corner)
      else
        (verticalBar above corner) beside (space above sp)
    }
  }

}

object A13AbstractElement {

  def elem(contents: Array[String]): A13AbstractElement = new A13ArrayElement(contents)

  def elem(line: String): A13AbstractElement = new A13LineElement(line)

  def elem(char: Char, width: Int, height: Int): A13AbstractElement =
    new A13UniformElement(char, width, height)

  private class A13ArrayElement(private val conts: Array[String]) extends A13AbstractElement {

    override val contents: Array[String] = conts

  }

  private class A13LineElement(s: String) extends A13AbstractElement {

    val contents = Array(s)

    override def width: Int = s.length

    override def height: Int = 1

  }

  private class A13UniformElement(
                                   ch: Char,
                                   override val width: Int,
                                   override val height: Int
                                 ) extends A13AbstractElement {

    private val line = ch.toString * width

    override def contents: Array[String] = Array.fill(height)(line)

  }

}

abstract class A13AbstractElement {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  /**
   * 将两个元素拼接在一起
   */
  def above(that: A13AbstractElement): A13AbstractElement = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }

  /**
   * 将两个元素并排放在一起
   */
  def beside(that: A13AbstractElement): A13AbstractElement = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for (
        (line1, line2) <- this1.contents zip that1.contents
      ) yield line1 + line2
    )
  }

  def widen(w: Int): A13AbstractElement =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten(h: Int): A13AbstractElement =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }

  /**
   * 重写 toString，空参数列表
   */
  override def toString: String = contents mkString "\n"

}

