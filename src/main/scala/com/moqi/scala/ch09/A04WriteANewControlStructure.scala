package com.moqi.scala.ch09

import java.io.{File, PrintWriter}
import java.util.Date

/**
 * 编写新的控制结构
 *
 * @author moqi On 11/3/20 17:52
 */
object A04WriteANewControlStructure {

  private val filePath = "./src/main/resources/output.txt"

  def main(args: Array[String]): Unit = {

    println(s"twice(_ + 10, 5) = ${twice(_ + 10, 5)}")
    println()

    withPrintWriter(
      new File(filePath),
      writer => writer.println(new Date)
    )
    println("withPrintWriter over")

    val file = new File(filePath)

    withPrintWriter2(file) { writer => writer.println("Hello World !!!!!") }
    println("withPrintWriter2 over")

  }

  def withPrintWriter2(file: File)(op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)

    try {
      op(writer)
    } finally {
      writer.close()
    }

  }

  def withPrintWriter(file: File, op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)

    try {
      op(writer)
    } finally {
      writer.close()
    }

  }

  /**
   * 重复某个操作两次
   */
  def twice(op: Double => Double, x: Double): Double = op(op(x))

}
