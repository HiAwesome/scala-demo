package com.moqi.scala.ch24

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, HashSet, TreeSet}

/**
 * 相等性
 *
 * @author moqi On 11/24/20 19:18
 */
object A13Equality {

  def main(args: Array[String]): Unit = {

    println(s"Set(1, 2, 3) == List(1, 2, 3) = ${Set(1, 2, 3) == List(1, 2, 3)}")
    println(s"List(1, 2, 3) == Vector(1, 2, 3) = ${List(1, 2, 3) == Vector(1, 2, 3)}")
    println(s"HashSet(1, 2) == TreeSet(2, 1) = ${HashSet(1, 2) == TreeSet(2, 1)}")
    println()

    val buf = ArrayBuffer(1, 2, 3)
    val map = mutable.HashMap(buf -> 3)
    println(s"map(buf) = ${map(buf)}")
    buf(0) += 1
    println(s"map(buf) = ${map(buf)}")
    println()

  }

}
