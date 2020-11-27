package com.moqi.scala.ch31

import java.util
import java.util.function.IntUnaryOperator

/**
 * Java 8 集成
 *
 * @author moqi On 11/27/20 17:32
 */
object A05Java8Integration {

  def main(args: Array[String]): Unit = {

    func1

    func2

  }

  private def func2: Unit = {
    val stream = util.Arrays.stream(Array(1, 2, 3))
    val v1 = stream.map(new IntUnaryOperator {
      override def applyAsInt(i: Int) = i + 1
    })
    val stream2 = util.Arrays.stream(Array(1, 2, 3))
    val v2 = stream2.map((i: Int) => i + 1)
    val stream3 = util.Arrays.stream(Array(1, 2, 3))
    val v3 = stream3.map(_ + 1)
    println(s"v1.toArray = ${v1.toArray.mkString("Array(", ", ", ")")}")
    println(s"v2.toArray = ${v2.toArray.mkString("Array(", ", ", ")")}")
    println(s"v3.toArray = ${v3.toArray.mkString("Array(", ", ", ")")}")
    println()
  }

  private def func1: Unit = {
    val v1 = increaseOne(new Increaser {
      override def increase(i: Int): Int = i + 7
    })
    val v2 = increaseOne((i: Int) => i + 7)
    val v3 = increaseOne(_ + 7)
    println(s"v1 = ${v1}")
    println(s"v2 = ${v2}")
    println(s"v3 = ${v3}")
    println()
  }

  def increaseOne(increaser: Increaser): Int = increaser.increase(1)

}

/**
 * 带有唯一方法的特质
 */
trait Increaser {
  def increase(i: Int): Int
}