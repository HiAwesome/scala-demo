package com.moqi.scala.ch16

/**
 * 同时处理多个列表
 *
 * @author moqi On 11/10/20 17:31
 */
object A09ProcessingMultipleListsTogether {

  def main(args: Array[String]): Unit = {

    val nums1 = (List(10, 20) zip List(3, 4, 5)).map{case (x, y) => x * y}
    println(s"nums1 = ${nums1}")
    val nums2 = (List(10, 20) lazyZip List(3, 4, 5)).map{_ * _}
    println(s"nums2 = ${nums2}")
    println(s"nums1 == nums2 = ${nums1 == nums2}")
    println()

    val b1 = (List("abc", "de") lazyZip List(3, 2)).forall(_.length == _)
    println(s"b1 = ${b1}")
    val b2 = (List("abc", "de") lazyZip List(3, 2)).exists(_.length != _)
    println(s"b2 = ${b2}")

  }

}
