package com.moqi.scala.ch04

import scala.collection.mutable

/**
 * 类、字段和方法 3
 *
 * @author moqi On 10/29/20 16:56
 */
class A03CheckSumAccumulator {
  private var sum = 0

  def add(b: Byte): Unit = sum += b

  def checkSum(): Int = ~(sum & 0xFF) + 1

}

object A03CheckSumAccumulator {

  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int = {

    if (cache.contains(s)) {
      cache(s)
    } else {
      val acc = new A03CheckSumAccumulator

      for (c <- s) {
        acc.add(c.toByte)
      }
      val cs = acc.checkSum()
      cache += (s -> cs)
      cs
    }

  }

}