package com.moqi.scala.ch16

import com.moqi.scala.ch16.A06FirstOrderMethodsOnClassList.msort
import com.moqi.scala.ch16.A06FirstOrderMethodsOnClassList.abcde

/**
 * 理解 Scala 的类型推断算法
 *
 * @author moqi On 11/10/20 19:10
 */
object A10TypeInference {

  def main(args: Array[String]): Unit = {

    val v1 = msort((x: Char, y: Char) => x > y)(abcde)
    println(s"v1 = ${v1}")
    println(s"abcde sortWith (_ > _) = ${abcde sortWith (_ > _)}")
    println()

    // msort 需要先用一个类型参数实例化之后才能被应用到它的入参上
    // val v2 = msort(_ > _)(abcde)

    val v2 = msort[Char](_ > _)(abcde)
    println(s"v2 = ${v2}")
    println(s"v1 == v2 = ${v1 == v2}")
    println()

    val v3 = msortSwapped(abcde)(_ > _)
    println(s"v3 = ${v3}")
    println(s"v1 == v3 = ${v1 == v3}")
    println()

  }

  /**
   * 重写 msort 方法，交换两个参数的位置
   */
  def msortSwapped[T](xs: List[T])(less: (T, T) => Boolean): List[T] = msort(less)(xs)

}
