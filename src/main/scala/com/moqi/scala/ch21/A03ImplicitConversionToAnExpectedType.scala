package com.moqi.scala.ch21

/**
 * 隐式转换到一个预期的类型
 *
 * @author moqi On 11/20/20 10:41
 */
object A03ImplicitConversionToAnExpectedType {

  /**
   * 隐式转换 double 到 int
   */
  implicit def doubleToInt(x: Double) = x.toInt

  def main(args: Array[String]): Unit = {

    val i: Int = 3.5
    println(s"i = ${i}")

  }


}
