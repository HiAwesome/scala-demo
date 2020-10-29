package com.moqi.scala.ch04

/**
 * 类、字段和方法 2
 *
 * @author moqi On 10/29/20 16:56
 */
class A02CheckSumAccumulator {
  private var sum = 0

  def add(b: Byte) = sum += b

  def checkSum() = ~(sum & 0xFF) + 1

}
