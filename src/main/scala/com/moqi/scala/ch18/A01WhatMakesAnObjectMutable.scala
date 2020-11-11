package com.moqi.scala.ch18

/**
 * 什么样的对象是可变的
 *
 * @author moqi On 11/11/20 11:12
 */
object A01WhatMakesAnObjectMutable {

  def main(args: Array[String]): Unit = {

    val cs = List('a', 'b', 'c')
    println(s"cs.head = ${cs.head}")
    println()

    val account = new BankAccount
    println(s"account = ${account}")
    account deposit 100
    println(s"account withdraw 80 = ${account withdraw 80}")
    println(s"account withdraw 80 = ${account withdraw 80}")
    println()

  }

}

/**
 * 一个可变的银行账号类
 */
class BankAccount {
  private var bal: Int = 0

  def balance: Int = bal

  def deposit(amount: Int): Unit = {
    require(amount > 0)
    bal += amount
  }

  def withdraw(amount: Int): Boolean =
    if (amount > bal) false
    else {
      bal -= amount
      true
    }
}

class Keyed {
  def computeKey: Int = 0 // 这需要花点时间的计算
}

/**
 * 定义字段是 var 但属于纯函数的类
 */
class MemoKeyed extends Keyed {
  private var keyCache: Option[Int] = None

  override def computeKey: Int = {
    // !keyCache.isDefined -> keyCache.isEmpty
    if (keyCache.isEmpty) keyCache = Some(super.computeKey)
    keyCache.get
  }

}