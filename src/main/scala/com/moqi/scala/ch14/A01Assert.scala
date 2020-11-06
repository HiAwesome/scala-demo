package com.moqi.scala.ch14

import com.moqi.scala.ch14.AbstractElement._

/**
 * 断言
 *
 * @author moqi On 11/6/20 17:51
 */
object A01Assert {

}

object AbstractElement {

  def elem(contents: Array[String]): AbstractElement = new ArrayElement(contents)

  def elem(line: String): AbstractElement = new LineElement(line)

  def elem(char: Char, width: Int, height: Int): AbstractElement =
    if (width > 0)
      new UniformElement(char, width, height)
    else
      throw new IllegalArgumentException("width can not be negative")

  private class ArrayElement(private val conts: Array[String]) extends AbstractElement {

    override val contents: Array[String] = conts

  }

  private class LineElement(s: String) extends AbstractElement {

    val contents = Array(s)

    override def width: Int = s.length

    override def height: Int = 1

  }

  private class UniformElement(
                                ch: Char,
                                override val width: Int,
                                override val height: Int
                              ) extends AbstractElement {

    private val line = ch.toString * width

    override def contents: Array[String] = Array.fill(height)(line)

  }

}

abstract class AbstractElement {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  /**
   * 将两个元素拼接在一起
   */
  def above(that: AbstractElement): AbstractElement = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    // 使用断言
    assert(this1.width == that1.width)
    elem(this1.contents ++ that1.contents)
  }

  /**
   * 将两个元素并排放在一起
   */
  def beside(that: AbstractElement): AbstractElement = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for (
        (line1, line2) <- this1.contents zip that1.contents
      ) yield line1 + line2
    )
  }

  def widen(w: Int): AbstractElement =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    // 用 ensuring 来断言函数的结果
    } ensuring (w <= _.width)

  def heighten(h: Int): AbstractElement =
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