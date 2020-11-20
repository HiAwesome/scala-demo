package com.moqi.scala.ch21

import com.moqi.scala.ch12.Rational

/**
 * 转换接收端
 *
 * @author moqi On 11/20/20 10:47
 */
object A04ConvertingTheReceiver {

  /**
   * 隐式转换 int 为 Rational 类型
   */
  implicit def intToRational(x: Int) = new Rational(x, 1)

  /**
   * 隐式类
   * 富包装类模式
   * 不能位于顶级目录，否则编译报错
   */
  implicit class RectangleMaker(width: Int) {
    def x(height: Int) = Rectangle(width, height)
  }


  def main(args: Array[String]): Unit = {

    func1

    func2

  }

  private def func2: Unit = {
    val myRectangle = 3 x 4
    println(s"myRectangle = ${myRectangle}")
    println()
  }

  private def func1: Unit = {
    val oneHalf = new Rational(1, 2)
    println(s"oneHalf + oneHalf = ${oneHalf + oneHalf}")
    println(s"oneHalf + 1 = ${oneHalf + 1}")

    // 加入隐式转换后代码可以执行
    println(s"1 + oneHalf = ${1 + oneHalf}")
    println()
  }
}

case class Rectangle(width: Int, height: Int)


