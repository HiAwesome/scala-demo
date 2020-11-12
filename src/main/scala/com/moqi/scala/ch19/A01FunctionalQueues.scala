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
 * 通过标记为私有来隐藏主构造方法
 */
class A01Queue[T](private val leading: List[T], private val trailing: List[T]) {

  private def mirror: A01Queue[T] =
    if (leading.isEmpty)
      new A01Queue(trailing.reverse, Nil)
    else
      this

  def head: T = mirror.leading.head

  def tail: A01Queue[T] = {
    val q = mirror
    new A01Queue(q.leading.tail, q.trailing)
  }

  def enqueue(x: T) = new A01Queue(leading, x :: trailing)

  /**
   * 辅助构造方法一
   */
  def this() = this(Nil, Nil)

  /**
   * 辅助构造方法二
   */
  def this(elements: T*) = this(elements.toList, Nil)

}

/**
 * 伴生对象中的 apply 工厂方法
 */
object A01Queue {

  /**
   * 用初始值 xs 构造队列
   */
  def apply[T](xs: T*) = new A01Queue[T](xs.toList, Nil)

}