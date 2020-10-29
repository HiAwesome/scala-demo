package com.moqi.scala.ch04

/**
 * 类、字段和方法
 *
 * @author moqi On 10/29/20 16:56
 */
class A01CheckSumAccumulator {
  private var sum = 0

  def add(b: Byte) : Unit = {
    sum += b
  }

  def checkSum(): Int = {
    ~(sum & 0xFF) + 1
  }

}
