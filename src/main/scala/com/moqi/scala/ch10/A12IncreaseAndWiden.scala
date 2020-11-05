package com.moqi.scala.ch10

import com.moqi.scala.ch10.A12AbstractElement._

/**
 * 增高和增宽
 *
 * @author moqi On 12/5/20 10:12
 */
object A12IncreaseAndWiden {

}

object A12AbstractElement {

  def elem(contents: Array[String]): A12AbstractElement = new A12ArrayElement(contents)

  def elem(line: String): A12AbstractElement = new A12LineElement(line)

  def elem(char: Char, width: Int, height: Int): A12AbstractElement =
    new A12UniformElement(char, width, height)

  private class A12ArrayElement(private val conts: Array[String]) extends A12AbstractElement {

    override val contents: Array[String] = conts

  }

  private class A12LineElement(s: String) extends A12AbstractElement {

    val contents = Array(s)

    override def width: Int = s.length

    override def height: Int = 1

  }

  private class A12UniformElement(
                                   ch: Char,
                                   override val width: Int,
                                   override val height: Int,
                                 ) extends A12AbstractElement {

    private val line = ch.toString * width

    override def contents: Array[String] = Array.fill(height)(line)

  }

}

abstract class A12AbstractElement {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  /**
   * 将两个元素拼接在一起
   */
  def above(that: A12AbstractElement): A12AbstractElement = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }

  /**
   * 将两个元素并排放在一起
   */
  def beside(that: A12AbstractElement): A12AbstractElement = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for (
        (line1, line2) <- this1.contents zip that1.contents
      ) yield line1 + line2
    )
  }

  def widen(w: Int): A12AbstractElement =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten(h: Int): A12AbstractElement =
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

