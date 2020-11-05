package com.moqi.scala.ch10

/**
 * 实现 above、beside 和 toString 方法
 *
 * @author moqi On 11/5/20 09:20
 */
object A10ImplementAboveBesideToString {

}

abstract class A10AbstractElement {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  /**
   * 将两个元素拼接在一起
   */
  def above(that: A10AbstractElement): A10AbstractElement =
    new A10ArrayElement(this.contents ++ that.contents)

  /**
   * 将两个元素并排放在一起
   * 第二版：使用函数式风格，避免了显式的数组下标
   * Array(1,2,3) zip Array("a", "b") => Array[(Int, String)] = Array((1,a), (2,b))
   */
  def beside(that: A10AbstractElement): A10AbstractElement = {
    new A10ArrayElement(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield  line1 + line2
    )
  }

  /**
   * 将两个元素并排放在一起
   * 第一版：使用指令式风格
   */
  def besideV0(that: A10AbstractElement): A10AbstractElement = {
    val contents = new Array[String](this.contents.length)

    // for (i <- 0 until this.contents.length)
    for (i <- this.contents.indices)
      contents(i) = this.contents(i) + that.contents(i)

    new A10ArrayElement(contents)
  }

  /**
   * 重写 toString，空参数列表
   */
  override def toString: String = contents mkString "\n"

}

class A10ArrayElement(private val conts: Array[String]) extends A10AbstractElement {

  override val contents: Array[String] = conts

}

class A10LineElement(s: String) extends A10AbstractElement {

  val contents = Array(s)

  override def width: Int = s.length

  override def height: Int = 1

}

class A10UniformElement(
                         ch: Char,
                         override val width: Int,
                         override val height: Int,
                       ) extends A10AbstractElement {

  private val line = ch.toString * width

  override def contents: Array[String] = Array.fill(height)(line)

}