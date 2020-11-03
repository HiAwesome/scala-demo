package com.moqi.scala.ch08

/**
 * 闭包
 *
 * @author moqi On 11/3/20 15:34
 */
object A07Closure {

  def main(args: Array[String]): Unit = {

    var sum = 0
    someNumbers.foreach(sum += _)
    println(s"sum = ${sum}")
    println()

    val inc1 = makeIncrease(1)
    val inc9999 = makeIncrease(9999)

    println(s"inc1(10) = ${inc1(10)}")
    println(s"inc9999(10) = ${inc9999(10)}")
    println()

  }

  val someNumbers = List(-11, -10, -5, 0, 5, 10)

  def makeIncrease(more: Int) = (x: Int) => x + more

}
