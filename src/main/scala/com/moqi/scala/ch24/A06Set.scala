package com.moqi.scala.ch24

/**
 * Set
 *
 * @author moqi On 11/23/20 16:45
 */
object A06Set {

  def main(args: Array[String]): Unit = {

    func1

    func2

  }

  /**
   * 通常可以用一个保存为 var 的不可变集合替换一个保存为 val 的可变集合，或者是反过来
   */
  private def func2: Unit = {
    var s = Set(1, 2, 3)
    s += 4;
    s -= 2;
    println(s"s = ${s}")
    println()

    val ls = collection.mutable.Set(1, 2, 3)
    ls += 4;
    ls -= 2;
    println(s"ls = ${ls}")
    println()
  }

  private def func1: Unit = {
    val fruit = Set("apple", "orange", "peach", "banana")
    val b1 = fruit("peach")
    val b2 = fruit("potato")
    println(s"b1 = ${b1}, b2 = ${b2}")
    println()
  }
}
