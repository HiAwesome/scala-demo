package com.moqi.scala.ch07

import java.io.{FileNotFoundException, FileReader, IOException}
import java.net.{MalformedURLException, URL}

/**
 * 用 Try 表达式实现异常处理
 *
 * @author moqi On 11/2/20 14:45
 */
object A04TryException {

  def main(args: Array[String]): Unit = {

    halfTest

    scalaTryCatch

    println(s"f() = ${f()}")
    println()

    println(s"urlFor(baidu) = ${urlFor("https://www.baidu.com")}")
    println(s"gooooooooooooooo = ${urlFor("gooooooooooooooo.com")}")
    println()

    println(s"g() = ${g()}")
    println()
  }

  /**
   * finally 不带 return 返回 1
   */
  def g(): Int = try 1 finally 2

  def urlFor(path: String) =
    try {
      new URL(path)
    } catch {
      // 抛出该异常指示URL格式错误。在规范字符串中找不到合法协议，或者无法分析字符串。
      case _: MalformedURLException => new URL("https://www.scala-lang.org")
    }

  /**
   * finally 带 return 返回 2
   */
  def f(): Int = try 1 finally return 2

  /**
   * Try Finally
   */
  private def scalaTryFinally = {
    val f = new FileReader("input.txt")
    try {
      // 使用文件
    } finally {
      // 确保关闭文件
      f.close()
    }

    println()
  }

  /**
   * Try Catch
   */
  private def scalaTryCatch = {
    try {
      val f = new FileReader("input.txt")
      // 使用并关闭文件
    } catch {
      case _: FileNotFoundException => println("文件不存在")
      case _: IOException => println("其他 IO 错误")
    }

    println()
  }

  private def halfTest: Unit = {
    println(s"half(10) = ${half(10)}")
    try {
      val h1 = s"${half(11)}"
      println(s"half(11) = $h1")
    } catch {
      case _: RuntimeException => println("A Runtime Exception Occurred")
    }

    println()
  }

  def half(n: Int) =
    if (n % 2 == 0) {
      n / 2
    } else {
      throw new RuntimeException("n must be even")
    }


}
