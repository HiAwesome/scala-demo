package com.moqi.scala.ch07

import java.io.File

import scala.io.Source.fromFile

/**
 * for 循环
 *
 * @author moqi On 11/2/20 11:31
 */
object A03ForLoop {

  def main(args: Array[String]): Unit = {

    iterateFile

    forArray

    forWithIfCondition

    forWithMultiIfCondition

    grep(".*scala-lang.*")

    grepWithMidStream(".*scala-lang.*")

    println(s"scalaFiles = ${scalaFiles.mkString("Array(", ", ", ")")}")
    println()

    // yield 关键字必须出现在整个代码体之前
    /*for (file <- fileHere if file.getName.endsWith(".scala")) {
      yield file // 语法错误
    }*/

    println(s"forLineLengths = ${forLineLengths.mkString("Array(", ", ", ")")}")
    println()
  }

  val forLineLengths =
    for {
      file <- fileHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(".*for.*")
    } yield trimmed.length

  /**
   * 产出一个新的集合
   * for 子句 yield 代码体
   */
  def scalaFiles =
    for {
      file <- fileHere
      if file.getName.endsWith(".scala")
    } yield file

  /**
   * 嵌套迭代
   */
  def grep(pattern: String) = {

    for (
      file <- fileTopDir
      if file.getName.contains("o");
      line <- fileLines(file)
      if line.trim.matches(pattern)
    ) println(file + ": " + line.trim)

    println()
  }

  /**
   * 嵌套迭代 + 中途变量绑定
   */
  def grepWithMidStream(pattern: String) = {

    for (
      file <- fileTopDir
      if file.getName.contains("o");
      line <- fileLines(file);
      trimmed = line.trim
      if trimmed.matches(pattern)
    ) println(file + ": " + trimmed)

    println()
  }


  /**
   * for 循环和多个过滤器
   */
  private def forWithMultiIfCondition: Unit = {

    for (
      file <- fileTopDir
      if file.isFile
      if file.getName.contains("o")
    ) println(s"file = ${file}")

    println()
  }

  /**
   * 函数式风格的 for 循环带上 if 过滤
   * 在指令式风格中 if 应该写在 for 循环内部
   */
  private def forWithIfCondition: Unit = {
    for (file <- fileTopDir if file.getName.contains("m")) {
      println(s"file = ${file}")
    }

    println()
  }

  /**
   * 迭代数组
   */
  private def forArray: Unit = {
    // to 包括上下界
    for (i <- 1 to 4) {
      println(s"i = ${i}")
    }
    println()

    // until 不包括上界
    for (j <- 1 until 4) {
      println(s"j = ${j}")
    }
    println()
  }

  /**
   * 迭代文件
   */
  private def iterateFile: Unit = {

    for (file <- fileTopDir) {
      println(s"file = ${file}")
    }

    println()
  }

  def fileTopDir = new File(".").listFiles()

  def fileHere = new File("./src/main/scala/com/moqi/scala/ch07").listFiles()

  //noinspection SourceNotClosed
  def fileLines(file: File) = fromFile(file).getLines().toList
}
