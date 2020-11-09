package com.moqi.scala.ch15

import math.{E, Pi}

/**
 * 模式的种类
 *
 * @author moqi On 11/8/20 16:10
 */
object A02TypesOfPatterns {

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

    func4

    func5

    func6

    func7

    func8

    func9

  }

  private def func9: Unit = {
    println(s"matchUpOn(UnOp(abs, )) = ${matchUpOn(UnOp("abs", UnOp("abs", Number(1))))}")
    println(s"matchUpOn(UnOp(abs, )) = ${matchUpOn(UnOp("abs", UnOp("not match operate", Number(1))))}")
    println(s"matchUpOn(Number(100)) = ${matchUpOn(Number(100))}")
    println()
  }

  private def func8: Unit = {
    println(s"isStringArray(Array(abc)) = ${isStringArray(Array("abc"))}")
    println(s"isStringArray(Array(1, 2, 3)) = ${isStringArray(Array(1, 2, 3))}")
    println()
  }

  private def func7: Unit = {
    println(s"isIntIntMap(Map(1 -> 10)) = ${isIntIntMap(Map(1 -> 10))}")
    println(s"isIntIntMap(Map(1 -> 'a')) = ${isIntIntMap(Map(1 -> 'a'))}")
    println(s"isIntIntMap(List(1, 2, 3)) = ${isIntIntMap(List(1, 2, 3))}")
    println()
  }

  private def func6: Unit = {
    println(s"generalSize(abc) = ${generalSize("abc")}")
    println(s"generalSize(Map(1 -> 'a', 2 -> 'b')) = ${generalSize(Map(1 -> 'a', 2 -> 'b'))}")
    println(s"generalSize(Pi) = ${generalSize(Pi)}")
    println()
  }

  private def func5: Unit = {
    println(s"tupleDemo((a , 3, -tuple)) = ${tupleDemo(("a ", 3, "-tuple"))}")
    println(s"tupleDemo((1, 1.0, 3.14, Pi)) = ${tupleDemo((1, 1.0, 3.14, Pi))}")
    println()
  }

  private def func4: Unit = {
    println(s"startWithZero1(List(0, 1, 2)) = ${startWithZero1(List(0, 1, 2))}")
    println(s"startWithZero1(List(0)) = ${startWithZero1(List(0))}")
    println(s"startWithZero2(List(0, 0, 0, 0, 0)) = ${startWithZero2(List(0, 0, 0, 0, 0))}")
    println(s"startWithZero2(List(0)) = ${startWithZero2(List(0))}")
    println()
  }

  private def func3: Unit = {
    // 大写字母开头的 case Pi 是常量
    val res1 = E match {
      case Pi => "strange math? Pi = " + Pi
      case _ => "Default OK"
    }
    println(s"res1 = ${res1}")

    val pi = math.Pi
    // 小写字母开头的 case pi 是变量
    val res2 = E match {
      // 这里 IDEA 会提示 Declaration is never used，因此可以简写为 case _, 所以事实上永远走不到下面的分支
      case pi => "strange math? Pi = " + Pi
      case _ => "Default OK"
    }
    println(s"res2 = ${res2}")

    // 反引号修饰的小写字母开头的 case pi 是常量
    val res3 = E match {
      case `pi` => "strange math? Pi = " + Pi
      case _ => "Default OK"
    }
    println(s"res3 = ${res3}")
    println()
  }

  private def func2: Unit = {
    println(s"startWithZero(0) = ${startWithZero(0)}")
    println(s"startWithZero(100) = ${startWithZero(100)}")
    println()
  }

  private def func1: Unit = {
    println(s"describe(5) = ${describe(5)}")
    println(s"describe(true) = ${describe(true)}")
    println(s"describe(hello) = ${describe("hello")}")
    println(s"describe(Nil) = ${describe(Nil)}")
    println(s"describe(List(1, 2, 3)) = ${describe(List(1, 2, 3))}")
    println()
  }

  /**
   * 通配模式 1
   */
  def checkBinary1(expr: Expr): String = expr match {
    case BinOp(op, left, right) => expr + " is a binary operation"
    case _ => "default branch"
  }

  /**
   * 通配模式 2
   * 使用 _ 来忽略不关心的局部，具体使用是 _, _, _
   */
  def checkBinary2(expr: Expr): String = expr match {
    case BinOp(_, _, _) => expr + " is a binary operation"
    case _ => "It's something else."
  }

  /**
   * 常量模式
   */
  def describe(x: Any): String = x match {
    case 5 => "file"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }

  /**
   * 变量模式
   */
  def startWithZero(expr: Any): String = expr match {
    case 0 => "zero"
    case somethingElse => "not zero: " + somethingElse
  }

  /**
   * 构造方法匹配
   * 这个示例是一个长度只有一行但深度有三层的模式
   */
  def deepMatch(expr: Expr): String = expr match {
    case BinOp("+", e, Number(0)) => "a deep match"
    case _ => "It's something else."
  }

  /**
   * 序列模式，比如 List 或者 Array
   * 固定长度的序列模式
   */
  def startWithZero1(expr: List[Int]): String = expr match {
    case List(0, _, _) => "found it"
    case _ => "It's something else."
  }

  /**
   * 序列模式，比如 List 或者 Array
   * 任意长度的序列模式
   * _* 可以匹配任意数量的元素，包括 0 个
   */
  def startWithZero2(expr: List[Int]): String = expr match {
    case List(0, _*) => "found it"
    case _ => "It's something else."
  }

  /**
   * 元祖模式
   */
  def tupleDemo(expr: Any): String = expr match {
    case (a, b, c) => "matched " + a + b + c
    case _ => "It's something else."
  }

  /**
   * 带类型的模式
   * 返回不同类型对象的大小或者长度
   */
  def generalSize(x: Any): Int = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }

  /**
   * Scala 类型转换
   * 使用 isInstanceOf 和 asInstanceOf（不良风格）
   */
  //noinspection TypeCheckCanBeMatch
  def isInstance(expr: Any) =
    if (expr.isInstanceOf[String]) {
      val s = expr.asInstanceOf[String]
      s.length
    } else 0

  /**
   * 类型擦除 Map 和 List
   * 类型被擦除 Map[Int, Int] 等于 Map[_, _]
   */
  def isIntIntMap(x: Any) = x match {
    case _: Map[Int, Int] => true
    case _ => false
  }

  /**
   * Array 不执行类型擦除，因为 Java 和 Scala 都进行了处理
   */
  def isStringArray(x: Any): String = x match {
    case _: Array[String] => "yes, it is string array"
    case _ => "no, it's not string array"
  }

  /**
   * 变量绑定
   * 通过 @ 字符进行绑定
   * 第一条规则匹配到内部的 UnOp 对象整体
   */
  def matchUpOn(expr: Expr) = expr match {
    case UnOp("abs", e@UnOp("abs", _)) => e
    case _ =>
  }

}
