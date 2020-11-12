package com.moqi.scala.ch19

/**
 * 下界
 *
 * @author moqi On 11/12/20 10:32
 */
object A05LowerBounds {

  def main(args: Array[String]): Unit = {

    // Int 类型作为下界加入 Double 数值
    val q = new A05Queue[Int](List(), List())
    val q1 = q.enqueue(123)
    println(s"q1 = ${q1}")
    println()

    val d1: Double = 33.333
    val q2 = q.enqueue(d1)
    println(s"q2 = ${q2}")

  }

}

/**
 * 带有下界的类型参数
 */
class A05Queue[+T](private val leading: List[T],
                   private val trailing: List[T]) {

  /**
   * U >: T 定义 U 的下界为 T，U 必须是 T 的超类型
   * 超类型和子类型是反身的，意思是一个类型同时是自己的超类型和子类型
   */
  def enqueue[U >: T](x: U) = new A05Queue[U](leading, x :: trailing)

  override def toString: String = leading.toString() + trailing.toString()

}