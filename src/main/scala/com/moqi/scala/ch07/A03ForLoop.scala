package com.moqi.scala.ch07

import java.io.File

/**
 * for 循环
 *
 * @author moqi On 11/2/20 11:31
 */
object A03ForLoop {

  def main(args: Array[String]): Unit = {

    iterateFile

  }

  /**
   * 迭代文件
   */
  private def iterateFile: Unit = {
    val fileHere = (new File("./src/main/resources")).listFiles()

    for (file <- fileHere) {
      println(s"file = ${file}")
    }
  }
}
