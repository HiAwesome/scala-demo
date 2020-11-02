package com.moqi.scala.ch07

/**
 * if 表达式
 *
 * @author moqi On 11/2/20 11:07
 */
object A01IfCondition {

  def main(args: Array[String]): Unit = {
    func1(args)

    func2(args)

    func3(args)
  }

  /**
   * 指令式风格
   */
  private def func1(args: Array[String]): Unit = {
    var fileName = "default.txt"
    if (!args.isEmpty) {
      fileName = args(0)
    }

    println(s"fileName = ${fileName}")
    println()
  }

  /**
   * 函数式风格
   */
  private def func2(args: Array[String]): Unit = {
    val fileName = if (!args.isEmpty) args(0) else "default.txt"
    println(s"fileName = ${fileName}")
    println()
  }

  /**
   * 函数式风格 等式推理
   */
  private def func3(args: Array[String]): Unit = {
    println(if (!args.isEmpty) args(0) else "default.txt")
  }

}
