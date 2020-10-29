package com.moqi.scala.ch03

/**
 * 识别函数式编程风格
 *
 * @author moqi On 10/29/20 15:22
 */
object A05Function {

  def main(args: Array[String]): Unit = {

    val args = Array("zero", "one", "two")
    printArgs1(args)
    printArgs2(args)
    printArgs3(args)

    val res = formatArgs(args)
    println(res)
    assert(res == "zero\none\ntwo")
    println()

  }

  private def formatArgs(args: Array[String]) = args.mkString("\n")

  private def printArgs1(args: Array[String]): Unit = {
    var i = 0

    while (i < args.length) {
      println(args(i))
      i += 1
    }

    println()
  }

  private def printArgs2(args: Array[String]): Unit = {

    for (arg <- args) {
      println(arg)
    }

    println()
  }

  private def printArgs3(args: Array[String]): Unit = {
    args.foreach(println)
    println()
  }

}
