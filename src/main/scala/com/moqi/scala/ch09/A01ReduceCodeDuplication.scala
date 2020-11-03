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

    for (file <- filesEnding2(".scala"))
      println(s"file.getName = ${file.getName}")
    println()

    for (file <- filesContaining2("Reduce"))
      println(s"file.getName = ${file.getName}")
    println()

    for (file <- filesRegex2(".*Reduce.*"))
      println(s"file.getName = ${file.getName}")
    println()

    for (file <- filesEnding3(".scala"))
      println(s"file.getName = ${file.getName}")
    println()

    for (file <- filesContaining3("Reduce"))
      println(s"file.getName = ${file.getName}")
    println()

    for (file <- filesRegex3(".*Reduce.*"))
      println(s"file.getName = ${file.getName}")
    println()

  }

  def fileHere = new File("./src/main/scala/com/moqi/scala/ch09").listFiles()

  /**
   * 第一版本代码
   */
  def filesEnding(query: String) =
    for (file <- fileHere; if file.getName.endsWith(query))
      yield file

  def filesContaining(query: String) =
    for (file <- fileHere; if file.getName.contains(query))
      yield file

  def filesRegex(query: String) =
    for (file <- fileHere; if file.getName.matches(query))
      yield file

  /**
   * 第二版本代码
   */
  def filesMatching2(query: String, matcher: (String, String) => Boolean) =
    for (file <- fileHere; if matcher(file.getName, query))
      yield file

  def filesEnding2(query: String) = filesMatching2(query, _.endsWith(_))

  def filesContaining2(query: String) = filesMatching2(query, _.contains(_))

  def filesRegex2(query: String) = filesMatching2(query, _.matches(_))


  /**
   * 第三版本代码
   */
  def filesMatching3(matcher: String => Boolean) =
    for (file <- fileHere; if matcher(file.getName))
      yield file

  def filesEnding3(query: String) = filesMatching3(_.endsWith(query))

  def filesContaining3(query: String) = filesMatching3(_.contains(query))

  def filesRegex3(query: String) = filesMatching3(_.matches(query))


}
