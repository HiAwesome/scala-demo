package com.moqi.scala.ch12

/**
 * 矩阵对象
 *
 * @author moqi On 11/6/20 15:20
 */
object A03MatrixObject {

  def main(args: Array[String]): Unit = {

    val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
    println(s"rect.left = ${rect.left}")
    println(s"rect.right = ${rect.right}")
    println(s"rect.width = ${rect.width}")

  }

}

class Point(val x: Int, val y: Int)

class RectangleV0(val topLeft: Point, val bottomRight: Point) {
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  // 以及更多几何方法……
}

abstract class ComponentV0 {
  def topLeft: Point
  def bottomRight: Point

  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  // 以及更多几何方法……
}

trait Rectangular {
  def topLeft: Point
  def bottomRight: Point

  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  // 以及更多几何方法……
}

abstract class Component extends Rectangular {
  // 其他方法……
}

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {
  // 其他方法……
}