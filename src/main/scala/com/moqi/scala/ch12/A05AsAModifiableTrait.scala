package com.moqi.scala.ch12

import scala.collection.mutable.ArrayBuffer

/**
 * 作为可叠加修改的特质
 *
 * @author moqi On 11/6/20 15:54
 */
object A05AsAModifiableTrait {

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

    func4

    func5

  }

  private def func5: Unit = {
    val queue = new BasicIntQueue with Filtering with Incrementing
    queue.put(-1)
    queue.put(0)
    queue.put(1)
    println(s"queue.get() = ${queue.get()}")
    println(s"queue.get() = ${queue.get()}")
    println(s"queue.get() = ${queue.get()}")
  }

  /**
   * 混入特质的顺序时重要的，粗略的讲，越靠右出现的特质越先起作用
   */
  private def func4: Unit = {
    val queue = new BasicIntQueue with Incrementing with Filtering
    queue.put(-1)
    queue.put(0)
    queue.put(1)
    println(s"queue.get() = ${queue.get()}")
    println(s"queue.get() = ${queue.get()}")
    println()
  }

  /**
   * 在 new 实例化时混入特质
   */
  private def func3: Unit = {
    val queue = new BasicIntQueue with Doubling
    practice(queue)
  }

  /**
   * 类混入特质
   */
  private def func2: Unit = {
    val queue = new MyIntQueue
    practice(queue)
  }

  /**
   * 不混入特质
   */
  private def func1: Unit = {
    val queue = new BasicIntQueue
    practice(queue)
  }

  private def practice(queue: IntQueue): Unit = {
    queue.put(10)
    queue.put(20)
    println(s"queue.get() = ${queue.get()}")
    println(s"queue.get() = ${queue.get()}")
    println()
  }
}

/**
 * IntQueue 抽象类
 */
abstract class IntQueue {
  def get(): Int

  def put(x: Int)
}


/**
 * 用 ArrayBuffer 实现的 BasicIntQueue
 */
class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]

  override def get(): Int = buf.remove(0)

  override def put(x: Int): Unit = buf += x
}

/**
 * 可叠加修改的特质 Doubling
 */
trait Doubling extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(2 * x)
}

class MyIntQueue extends BasicIntQueue with Doubling

/**
 * 可叠加修改的特质 Incrementing
 */
trait Incrementing extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(x + 1)
}

/**
 * 可叠加修改的特质 Filtering
 */
trait Filtering extends IntQueue {
  abstract override def put(x: Int): Unit = if (x >= 0) super.put(x)
}
