package com.moqi.scala.ch24

/**
 * 从头创建集合
 *
 * @author moqi On 11/25/20 10:22
 */
object A16CreatingCollectionsFromScratch {

  def main(args: Array[String]): Unit = {

    val l1 = List.apply(1.0, 2.0)
    val l2 = List(1, 2, 3)
    val i1 = Iterable(1, 2, 3)
    val mi1 = collection.mutable.Iterable(1, 2, 3)
    println(s"l1 = ${l1}")
    println(s"l2 = ${l2}")
    println(s"i1 = ${i1}")
    println(s"mi1 = ${mi1}")
    println()

  }

}
