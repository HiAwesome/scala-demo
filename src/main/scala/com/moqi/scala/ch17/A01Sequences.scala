package com.moqi.scala.ch17

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
 * 序列
 *
 * @author moqi On 11/11/20 09:20
 */
object A01Sequences {

  def main(args: Array[String]): Unit = {

    // 列表
    val colors = List("red", "blue", "green")
    println(s"colors.head = ${colors.head}")
    println(s"colors.tail = ${colors.tail}")
    println(s"colors(1) = ${colors(1)}")
    println()

    // 数组
    val fiveInts = new Array[Int](5)
    println(s"fiveInts = ${fiveInts.mkString("Array(", ", ", ")")}")
    val fiveToOne = Array(5, 4, 3, 2, 1)
    println(s"fiveToOne = ${fiveToOne.mkString("Array(", ", ", ")")}")
    fiveInts(0) = fiveToOne(4)
    println(s"fiveInts = ${fiveInts.mkString("Array(", ", ", ")")}")
    println()

    // 列表缓冲
    val buf = new ListBuffer[Int]
    buf += 1
    buf += 2
    println(s"buf = ${buf}")
    3 +=: buf
    println(s"buf = ${buf}")
    println()

    // 数组缓冲
    val aBuf = new ArrayBuffer[Int]()
    aBuf += 11
    aBuf += 22
    println(s"aBuf = ${aBuf}")
    33 +=: aBuf
    println(s"aBuf = ${aBuf}")
    println(s"aBuf.length = ${aBuf.length}")
    println(s"aBuf(0) = ${aBuf(0)}")

    // 字符串（通过 StringOps），由于 Predef 有一个从 String 到 StringOps 的隐式转换，可以将任何字符串作为序列处理
    def hasUpperCase(s: String) = s.exists(_.isUpper)
    val h1 = hasUpperCase("Robert Frost")
    val h2 = hasUpperCase("e e cummings")
    println(s"h1 = ${h1}, h2 = ${h2}")
    println()

  }

}
