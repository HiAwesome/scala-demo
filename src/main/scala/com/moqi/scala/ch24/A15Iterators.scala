package com.moqi.scala.ch24

/**
 * 迭代器：迭代器并不是集合，而是逐个访问集合元素的一种方式
 *
 * @author moqi On 11/25/20 09:51
 */
object A15Iterators {

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

  }

  private def func3: Unit = {
    val it = Iterator(1, 2, 3, 4)
    val bit = it.buffered
    println(s"bit.head = ${bit.head}")
    println(s"bit.next() = ${bit.next()}")
    println(s"bit.next() = ${bit.next()}")
    println()
  }

  /**
   * 带缓冲区的迭代器
   * 对一个带缓冲区的迭代器调用 head 将返回它的第一个元素，不过并不会推荐迭代器到下一步
   */
  def skipEmptyWords(it: collection.BufferedIterator[String]): Unit =
    while (it.head.isEmpty) {
      it.next()
    }

  private def func2: Unit = {
    val it = Iterator("a", "number", "of", "word")
    it dropWhile (_.length < 2)
    println(s"it.next() = ${it.next()}")
    println()

    val (it1, it2) = it.duplicate
    println(s"it1 = ${it1}, it2 = ${it2}")
    println()
  }

  private def func1: Unit = {
    val it = Iterator("a", "number", "of", "word")
    println(s"it map (_.length) = ${it map (_.length)}")
    println()

    it map (_.length) foreach println
    println()

    // next on empty iterator
    // println(s"it.next() = ${it.next()}")
  }
}
