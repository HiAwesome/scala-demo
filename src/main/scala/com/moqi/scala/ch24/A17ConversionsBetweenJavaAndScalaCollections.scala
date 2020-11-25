package com.moqi.scala.ch24

import java.util

import scala.jdk.CollectionConverters._
import collection.mutable._
import scala.collection.mutable

/**
 * Java 和 Scala 集合互转
 *
 * @author moqi On 11/25/20 10:31
 */
object A17ConversionsBetweenJavaAndScalaCollections {

  def main(args: Array[String]): Unit = {

    func1

    func2

  }

  /**
   * List 的不可变性会得到维护，因此会在新增元素时抛出 UnsupportedOperationException
   */
  private def func2: Unit = {
    val jul: util.List[Int] = List(1, 2, 3).asJava
    println(s"jul = ${jul}")
    jul.add(7)
  }

  private def func1: Unit = {
    val jul: util.List[Int] = ArrayBuffer(1, 2, 3).asJava
    println(s"jul = ${jul}")
    val buf: mutable.Seq[Int] = jul.asScala
    println(s"buf = ${buf}")
    println()

    val map: util.Map[String, Int] = mutable.HashMap("abc" -> 1, "hello" -> 2).asJava
    println(s"map = ${map}")
    println()
  }
}
