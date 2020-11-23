package com.moqi.scala.ch24

import scala.collection.immutable.Queue

/**
 * 具体的不可变集合类
 *
 * @author moqi On 11/23/20 17:15
 */
object A08ConcreteImmutableCollectionClasses {

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

    func4

    func5

    func6

    func7

    func8

    func9

  }

  /**
   * ListMap
   */
  private def func9: Unit = {
    val map = collection.immutable.ListMap(1 -> "one", 2 -> "two")
    println(s"map(2) = ${map(2)}")
    println()
  }

  /**
   * VectorMap
   */
  private def func8: Unit = {
    val vm = collection.immutable.VectorMap.empty[Int, String]
    val vm1 = vm + (1 -> "one")
    val vm2 = vm1 + (2 -> "two")
    println(s"vm2 = ${vm2}")
    println()
  }

  /**
   * BitSet 测试某个位组是否包含某个值只需要常量的时间
   * 往位组添加条目需要的时间跟位组的 long 数组长度成正比，这通常是个很小的值
   */
  private def func7: Unit = {
    val bits = collection.immutable.BitSet.empty
    val moreBits = bits + 3 + 4 + 4
    println(s"moreBits(3) = ${moreBits(3)}")
    println(s"moreBits(0) = ${moreBits(0)}")
    println()
  }

  /**
   * TreeSet
   */
  private def func6: Unit = {
    val set = collection.immutable.TreeSet.empty[Int]
    val set2 = set + 1 + 3 + 3
    println(s"set2 = ${set2}")
    println()
  }

  /**
   * 区间 Range
   */
  private def func5: Unit = {
    val r1 = 1 to 3
    println(s"r1 = ${r1}")
    println(s"r1.toList = ${r1.toList}")
    println()

    val r2 = 5 to 14 by 3
    println(s"r2 = ${r2}")
    println(s"r2.toList = ${r2.toList}")
    println()

    val r3 = 1 until 3
    println(s"r3 = ${r3}")
    println(s"r3.toList = ${r3.toList}")
    println()
  }

  /**
   * 不可变的队列 Queue
   */
  private def func4: Unit = {
    val queue = Queue[Int]()
    val has1 = queue.enqueue(1)
    val has123 = has1.enqueueAll(List(2, 3))
    println(s"has123 = ${has123}")
    println()

    val (element, has23) = has123.dequeue
    println(s"element = ${element}, has23 = ${has23}")
    println()
  }

  /**
   * 向量 Vector 2
   */
  private def func3: Unit = {
    val vec = Vector(1, 2, 3)
    val vec1 = vec updated(2, 4)
    println(s"vec1 = ${vec1}")
    println()

    val indexedSeq1 = IndexedSeq(1, 2, 3)
    println(s"indexedSeq1 = ${indexedSeq1}")
    println()
  }

  /**
   * 向量 Vector 1
   */
  private def func2: Unit = {
    val vec = collection.immutable.Vector.empty
    val vec2 = vec :+ 1 :+ 2
    println(s"vec2 = ${vec2}")
    val vec3 = 100 +: vec2
    println(s"vec3 = ${vec3}")
    println(s"vec3(0) = ${vec3(0)}")
    println()
  }

  /**
   * 使用 LazyList 替代 Stream
   */
  private def func1: Unit = {
    val str: LazyList[Int] = 1 #:: 2 #:: 2 #:: 3 #:: LazyList.empty
    println(s"str = ${str}")
    println()

    val fibs = fibFrom(1, 1).take(7)
    println(s"fibs = ${fibs}")
    println(s"fibs.toList = ${fibs.toList}")
    println()
  }

  /**
   * 斐波那契数列
   */
  def fibFrom(a: Int, b: Int): LazyList[Int] = a #:: fibFrom(b, a + b)

}
