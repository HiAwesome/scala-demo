package com.moqi.scala.ch08

import java.io.File

import scala.io.Source

/**
 * 局部函数
 * processLine 定义在 processFile 内部
 *
 * @author moqi On 11/3/20 10:24
 */
object A02LocalFunction {

  def main(args: Array[String]): Unit = {

    val fileName = new File("./LICENSE").getName
    processFile(fileName, 4)

  }


  def processFile(fileName: String, width: Int): Unit = {
    // 局部函数可以访问包含它们函数的参数
    def processLine(line: String): Unit =
      if (line.length > width) println(fileName + ": " + line.trim)

    val source = Source.fromFile(fileName)
    for (line <- source.getLines())
      processLine(line)
  }

}
