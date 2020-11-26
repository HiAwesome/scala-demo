package com.moqi.scala.ch28

import scala.xml.Elem

/**
 * 序列化
 *
 * @author moqi On 11/26/20 11:46
 */
object A04Serialization {

  def main(args: Array[String]): Unit = {

    func1

    func2

  }

  private def func2: Unit = {
    val x1 = <a>{{{{brace yourself!}}}}</a>
    println(s"x1 = ${x1}")
    println()
  }

  private def func1: Unit = {
    val therm = new CCTherm {
      override val description: String = "hot dog #5"
      override val yearMade: Int = 1952
      override val dateObtained: String = "March 14, 2006"
      override val bookPrice: Int = 2199
      override val purchasePrice: Int = 500
      override val condition: Int = 9
    }

    println(s"therm.toXML = ${therm.toXML}")
    println()
  }
}

abstract class CCTherm {
  val description: String
  val yearMade: Int
  val dateObtained: String
  val bookPrice: Int
  val purchasePrice: Int
  val condition: Int

  override def toString: String = description

  /**
   * 这个方法不要格式化成三倍的行
   */
  def toXML: Elem =
    <cctherm>
      <description>{description}</description>
      <yearMade>{yearMade}</yearMade>
      <dateObtained>{dateObtained}</dateObtained>
      <bookPrice>{bookPrice}</bookPrice>
      <purchasePrice>{purchasePrice}</purchasePrice>
      <condition>{condition}</condition>
    </cctherm>
}