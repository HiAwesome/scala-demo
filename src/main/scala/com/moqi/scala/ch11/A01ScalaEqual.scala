package com.moqi.scala.ch11

/**
 * Scala == 比较
 *
 * @author moqi On 11/5/20 16:07
 */
object A01ScalaEqual {

  def main(args: Array[String]): Unit = {

    println(s"isEqual1(421, 421) = ${isEqual1(421, 421)}")
    println(s"isEqual2(421, 421) = ${isEqual2(421, 421)}")

  }

  def isEqual1(x: Int, y: Int) = x == y

  def isEqual2(x: Any, y: Any) = x == y

}
