package com.moqi.scala.ch19

import scala.collection.immutable.Queue

/**
 * 函数式队列
 *
 * @author moqi On 11/11/20 17:25
 */
object A01FunctionalQueues {

  def main(args: Array[String]): Unit = {

    val q = Queue(1, 2, 3)
    println(s"q = ${q}")
    val q1 = q enqueue 4
    println(s"q1 = ${q1}")
    println(s"q = ${q}")
    println()

  }


}

/**
 * 基本的函数式队列
 */
class Queue[T](private val leading: List[T], private val trailing: List[T]) {

  private def mirror: Queue[T] =
    if (leading.isEmpty)
      new Queue(trailing.reverse, Nil)
    else
      this

  def head: T = mirror.leading.head

  def tail: Queue[T] = {
    val q = mirror
    new Queue(q.leading.tail, q.trailing)
  }

  def enqueue(x: T) = new Queue(leading, x :: trailing)

}