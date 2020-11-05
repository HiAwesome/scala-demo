package com.moqi.scala.ch10

/**
 * 定义工厂对象
 *
 * @author moqi On 11/5/20 09:20
 */
object A11DefineFactoryObjects {

}

object A11AbstractElement {

  def elem(contents: Array[String]): A11AbstractElement = new A11ArrayElement(contents)

  def elem(line: String): A11AbstractElement = new A11LineElement(line)

  def elem(char: Char, width: Int, height: Int): A11AbstractElement =
    new A11UniformElement(char, width, height)

  private class A11ArrayElement(private val conts: Array[String]) extends A11AbstractElement {

    override val contents: Array[String] = conts

  }

  private class A11LineElement(s: String) extends A11AbstractElement {

    val contents = Array(s)

    override def width: Int = s.length

    override def height: Int = 1

  }

  private class A11UniformElement(
                                   ch: Char,
                                   override val width: Int,
                                   override val height: Int,
                                 ) extends A11AbstractElement {

    private val line = ch.toString * width

    override def contents: Array[String] = Array.fill(height)(line)

  }

}

abstract class A11AbstractElement {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  /**
   * 将两个元素拼接在一起
   */
  def above(that: A11AbstractElement): A11AbstractElement =
    A11AbstractElement.elem(this.contents ++ that.contents)

  /**
   * 将两个元素并排放在一起
   */
  def beside(that: A11AbstractElement): A11AbstractElement = {
    A11AbstractElement.elem(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )
  }

  /**
   * 重写 toString，空参数列表
   */
  override def toString: String = contents mkString "\n"

}

