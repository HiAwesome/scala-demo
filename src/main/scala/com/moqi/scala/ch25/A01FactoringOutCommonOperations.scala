package com.moqi.scala.ch25

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * 集合构建器
 *
 * @author moqi On 11/25/20 10:48
 */
object A01FactoringOutCommonOperations {

  def main(args: Array[String]): Unit = {

    val buf = new ArrayBuffer[Int]()
    val bldr = buf mapResult (_.toArray)
    println(s"bldr.getClass = ${bldr.getClass}")
    val newBldr: mutable.Builder[Int, Array[Int]] = new mutable.GrowableBuilder[Int, ArrayBuffer[Int]](buf).mapResult(_.toArray)
    println(s"newBldr = ${newBldr}")

  }

}
