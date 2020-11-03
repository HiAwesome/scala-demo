package com.moqi.scala.ch08

/**
 * 占位符语法
 *
 * @author moqi On 11/3/20 10:46
 */
object A05PlaceholderSyntax {

  def main(args: Array[String]): Unit = {

    println(someNumbers.filter(_ > 0))
    println()

    println(s"f(10, 20) = ${f(10, 20)}")
    println()

  }

  /**
   * 编译器没有足够多的信息来推断缺失的类型，可以用冒号给出
   */
  val f = (_: Int) + (_: Int)

  val someNumbers = List(-11, -10, -5, 0, 5, 10)

}
