package com.moqi.scala.ch09

import java.io.File

/**
 * 减少代码重复
 *
 * @author moqi On 11/3/20 16:29
 */
object A01ReduceCodeDuplication {

  def main(args: Array[String]): Unit = {

    for (file <- filesEnding(".scala"))
      println(s"file.getName = ${file.getName}")
    println()

    for (file <- filesContaining("Reduce"))
      println(s"file.getName = ${file.getName}")
    println()

    for (file <- filesRegex(".*Reduce.*"))
      println(s"file.getName = ${file.getName}")
    println()

  }

  def fileHere = new File("./src/main/scala/com/moqi/scala/ch09").listFiles()

  def filesEnding(query: String) =
    for (file <- fileHere; if file.getName.endsWith(query))
      yield file

  def filesContaining(query: String) =
    for (file <- fileHere; if file.getName.contains(query))
      yield file

  def filesRegex(query: String) =
    for (file <- fileHere; if file.getName.matches(query))
      yield file

}
