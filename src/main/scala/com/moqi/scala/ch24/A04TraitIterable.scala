package com.moqi.scala.ch24

/**
 * Iterable 特质
 *
 * @author moqi On 11/23/20 16:06
 */
object A04TraitIterable {

  def main(args: Array[String]): Unit = {

    func1

    // 对于 Seq 来说， apply 是位置下标
    println(s"Seq(1, 2, 3)(1) = ${Seq(1, 2, 3)(1)}")
    // 对于 Set 来说， apply 是成员测试
    println(s"Set('a', 'b', 'c')('b') = ${Set('a', 'b', 'c')('b')}")
    // 对于 Map 来说， apply 是选择
    println(s"Map('a' -> 1, 'b' -> 10, 'c' -> 100)('b') = ${Map('a' -> 1, 'b' -> 10, 'c' -> 100)('b')}")

  }

  private def func1: Unit = {
    val xs = List(1, 2, 3, 4, 5)
    val git = xs grouped 3
    println(s"git.next() = ${git.next()}")
    println(s"git.next() = ${git.next()}")
    println()

    val sit = xs sliding 3
    println(s"sit.next() = ${sit.next()}")
    println(s"sit.next() = ${sit.next()}")
    println(s"sit.next() = ${sit.next()}")
    println()
  }
}

sealed abstract class Tree

case class Branch(left: Tree, right: Tree) extends Tree

case class Node(elem: Int) extends Tree