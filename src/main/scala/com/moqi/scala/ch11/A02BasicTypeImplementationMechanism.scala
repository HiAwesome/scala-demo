package com.moqi.scala.ch11

/**
 *
 * 基本类型的实现机制
 *
 * @author moqi On 11/5/20 16:07
 */
object A02BasicTypeImplementationMechanism {

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

  }

  private def func3: Unit = {
    val x = new String("abc")
    val y = new String("abc")
    println(s"x == y = ${x == y}")
    println(s"x eq y = ${x eq y}")
    println(s"x ne y = ${x ne y}")
    println()
  }

  private def func2: Unit = {
    val x = "abcd".substring(2)
    val y = "abcd".substring(2)
    println(s"x == y = ${x == y}")
    println()
  }

  private def func1: Unit = {
    println(s"isEqual1(421, 421) = ${isEqual1(421, 421)}")
    println(s"isEqual2(421, 421) = ${isEqual2(421, 421)}")
    println()
  }

  def isEqual1(x: Int, y: Int) = x == y

  def isEqual2(x: Any, y: Any) = x == y

}
