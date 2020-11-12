package com.moqi.scala.ch19

/**
 * 对象私有数据
 *
 * @author moqi On 11/12/20 11:00
 */
object A07ObjectPrivateData {

  def main(args: Array[String]): Unit = {

    val q = new A07Queue[Int]
    val q1 = q.enqueue(10)
    println(s"q = ${q}, q1 = ${q1}")

    val q2 = q1.enqueue(33.33)
    println(s"q = ${q}, q2 = ${q2}")
    println()

  }

}

/**
 * 使用型变优化后的函数式 Queue
 * 在检查带有 + 或 - 的类型参数只应出现在相同型变归类的位点时
 * 会忽略掉私有对象的定义
 * 因此这两个 private[this] 不可以去除，否则会编译出错
 */
class A07Queue[+T] private(private[this] var leading: List[T],
                           private[this] var trailing: List[T]) {

  def this() = this(Nil, Nil)

  override def toString: String = leading.toString() + trailing.toString()

  private def mirror() =
    if (leading.isEmpty) {
      while (trailing.nonEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }

  def heat: T = {
    mirror()
    leading.head
  }

  def tail: A07Queue[T] = {
    mirror()
    new A07Queue(leading.tail, trailing)
  }

  def enqueue[U >: T](x: U) = new A07Queue[U](leading, x :: trailing)
}