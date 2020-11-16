package com.moqi.scala.ch20

/**
 * 案例分析：货币
 *
 * @author moqi On 11/16/20 09:54
 */
object A10Currencies {

  def main(args: Array[String]): Unit = {

    func1

  }

  private def func1: Unit = {
    val c1 = new Currency {
      override val amount: Long = 79L

      override def designation = "UDS"
    }
    println(s"c1 = ${c1}")
    println()
  }
}

abstract class Currency {
  val amount: Long

  def designation: String

  override def toString: String = amount + " " + designation

  //def +(that: Currency): Currency = ...

  //def *(x: Double): Currency = ...
}