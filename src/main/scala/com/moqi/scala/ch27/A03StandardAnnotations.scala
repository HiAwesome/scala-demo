package com.moqi.scala.ch27

import scala.annotation.meta.{getter, setter}
import scala.annotation.tailrec
import scala.beans.BeanProperty

/**
 * 标准注解
 *
 * @author moqi On 11/26/20 10:54
 */
object A03StandardAnnotations {

  def main(args: Array[String]): Unit = {


  }

  @deprecated
  def f(): Unit = {}

  @volatile
  def a = "a string"

  @SerialVersionUID(1)
  case class Person1(name: String, age: Int)

  @SerialVersionUID(1)
  case class Person2(name: String, age: Int, @transient address: String)

  @SerialVersionUID(1)
  case class Person3(@getter name: String, @setter age: Int, @transient address: String)

  @SerialVersionUID(1)
  @BeanProperty
  case class Person4(name: String, age: Int, @transient address: String)

  /**
   * 取两个数的最大公约数
   */
  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def methodA(paraA: String): String = (paraA: @unchecked) match {
    case "tom" => "Hello, tom"
    case _ => "Hello!"
  }

  @native
  def methodB() = {}

}
