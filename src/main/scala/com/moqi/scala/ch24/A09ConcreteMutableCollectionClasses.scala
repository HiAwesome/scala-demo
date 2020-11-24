package com.moqi.scala.ch24

import scala.collection.mutable

/**
 * 具体的可变集合类
 *
 * @author moqi On 11/23/20 17:58
 */
object A09ConcreteMutableCollectionClasses {

  def main(args: Array[String]): Unit = {

    arrayBuffer

    listBuffer

    stringBuilder

    queue

    stack

    hashMap

    bitSet

  }

  private def bitSet: Unit = {
    val bits = mutable.BitSet.empty
    bits += 1
    bits += 3
    println(s"bits = ${bits}")
    println()
  }

  private def hashMap: Unit = {
    val map = mutable.HashMap.empty[Int, String]
    map += (1 -> "make a web site")
    map += (3 -> "profit!")
    println(s"map(1) = ${map(1)}")
    println(s"map contains 2 = ${map contains 2}")
    println()
  }

  private def stack: Unit = {
    val stack = new mutable.Stack[Int]
    stack.push(1)
    println(s"stack = ${stack}")
    stack.push(2)
    println(s"stack = ${stack}")
    println(s"stack.top = ${stack.top}")
    println(s"stack = ${stack}")
    val ele = stack.pop()
    println(s"ele = ${ele}, stack = ${stack}")
    println()
  }

  private def queue: Unit = {
    val queue = new mutable.Queue[String]()
    queue += "a"
    queue ++= List("b", "c")
    println(s"queue = ${queue}")
    val ele = queue.dequeue()
    println(s"ele = ${ele}, queue = ${queue}")
    println()
  }

  private def stringBuilder: Unit = {
    val buf = new StringBuilder
    buf += 'a'
    buf ++= "bcdefgh"
    println(s"buf.toString() = ${buf.toString()}")
    println()
  }

  private def listBuffer: Unit = {
    val buf = collection.mutable.ListBuffer.empty[Int]
    buf += 1
    buf += 10
    println(s"buf.toList = ${buf.toList}")
    println()
  }

  private def arrayBuffer: Unit = {
    val buf = collection.mutable.ArrayBuffer.empty[Int]
    buf += 1
    buf += 10
    println(s"buf.toArray = ${buf.toArray.mkString("Array(", ", ", ")")}")
    println()
  }
}
