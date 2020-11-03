package com.moqi.scala.ch08

import java.io.File

import scala.io.Source

/**
 * 方法
 *
 * @author moqi On 11/3/20 10:12
 */
object A01Method {

  def main(args: Array[String]): Unit = {

    val fileName = new File("./LICENSE").getName
    processFile(fileName, 4)

  }

  def processLine(fileName: String, width: Int, line: String) =
    if (line.length > width) println(fileName + ": " + line.trim)

  def processFile(fileName: String, width: Int) = {
    val source = Source.fromFile(fileName)
    for (line <- source.getLines())
      processLine(fileName, width, line)
  }

}
