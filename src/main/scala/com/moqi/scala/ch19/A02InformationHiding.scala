package com.moqi.scala.ch19

/**
 * 信息隐藏
 *
 * @author moqi On 11/11/20 19:02
 */
object A02InformationHiding {

  def main(args: Array[String]): Unit = {

    func1

    func2

  }

  private def func2: Unit = {
    val q = A02Queue(1, 2, 3)
    println(s"q = ${q}")
    val q1 = q enqueue 4
    println(s"q1 = ${q1}")
    println(s"q = ${q}")
    println()
  }

  private def func1: Unit = {
    // Queue 为自定义的 Queue
    val q = Queue(1, 2, 3)
    println(s"q = ${q}")
    val q1 = q enqueue 4
    println(s"q1 = ${q1}")
    println(s"q = ${q}")
    println()
  }
}

trait A02Queue[T] {
  def head: T

  def tail: A02Queue[T]

  def enqueue(x: T): A02Queue[T]
}

/**
 * 激进的方式是隐藏类本身，并且只暴露一个反映类公有接口的特质
 */
object A02Queue {
  def apply[T](xs: T*): A02Queue[T] = new QueueImpl[T](xs.toList, Nil)

  private class QueueImpl[T](
                              private val leading: List[T],
                              private val trailing: List[T]
                            ) extends A02Queue[T] {

    def mirror =
      if (leading.isEmpty)
        new QueueImpl(trailing.reverse, Nil)
      else
        this

    def head: T = mirror.leading.head

    def tail: QueueImpl[T] = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }

    def enqueue(x: T) = new QueueImpl(leading, x :: trailing)

  }

}