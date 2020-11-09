package com.moqi.scala.ch15

import com.moqi.scala.ch13.bobs.Fruits.{Apple, Orange}

/**
 * 到处都是模式
 *
 * @author moqi On 11/9/20 11:52
 */
object A07PatternEverywhere {

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

  }

  /**
   * for 表达式中的模式
   */
  private def func3: Unit = {
    // 带有元祖模式的 for 表达式，匹配永远不会失败
    for ((country, city) <- Map("France" -> "Paris", "Japan" -> "Tokyo"))
      println("The capital of " + country + " is " + city)
    println()
    // 从列表中选取匹配特定模式的元素
    val results = List(Some(Apple), None, Some(Orange))
    for (Some(fruit) <- results)
      println(s"fruit = ${fruit}")
    println()
  }

  /**
   * 作为偏函数的 case 序列
   */
  private def func2: Unit = {
    val withDefault: Option[Int] => Int = {
      case Some(x) => x
      case None => 0
    }
    println(s"withDefault(Some(10)) = ${withDefault(Some(10))}")
    println(s"withDefault(None) = ${withDefault(None)}")
    println()

    val second: List[Int] => Int = {
      case x :: y :: _ => y
    }
    println(s"second(List(1, 2, 3)) = ${second(List(1, 2, 3))}")
    try {
      println(s"second(List()) = ${second(List())}")
    } catch {
      case e: MatchError => println(s"e.getMessage() = ${e.getMessage()}")
    }
    println()

    val secondPartial: PartialFunction[List[Int], Int] = {
      case x :: y :: _ => y
    }
    println(s"secondPartial.isDefinedAt(List(1, 2, 3)) = ${secondPartial.isDefinedAt(List(1, 2, 3))}")
    println(s"secondPartial(List(1, 2, 3)) = ${secondPartial(List(1, 2, 3))}")
    println(s"secondPartial.isDefinedAt(List()) = ${secondPartial.isDefinedAt(List())}")
    try {
      println(s"secondPartial(List()) = ${secondPartial(List())}")
    } catch {
      case e: MatchError => println(s"e.getMessage() = ${e.getMessage()}")
    }
    println()

    // secondPartial 将被翻译成如下的偏函数
    new PartialFunction[List[Int], Int] {
      override def apply(xs: List[Int]): Int = xs match {
        case x :: y :: _ => y
      }

      override def isDefinedAt(xs: List[Int]): Boolean = xs match {
        case x :: y :: _ => true
        case _ => false
      }
    }
  }

  /**
   * 变量定义中的模式
   * 在处理样例类时非常有用
   */
  private def func1: Unit = {
    val myTuple = (123, "abc")
    val (number, string) = myTuple
    println(s"number = ${number}")
    println(s"string = ${string}")
    println()

    val exp = BinOp("*", Number(5), Number(1))
    val BinOp(op, left, right) = exp
    println(s"op = ${op}")
    println(s"left = ${left}")
    println(s"right = ${right}")
  }
}
