package com.moqi.scala.ch19

/**
 * 检查型变注解
 *
 * @author moqi On 11/12/20 10:10
 */
object A04CheckingVarianceAnnotations {

  def main(args: Array[String]): Unit = {

    func1

  }

  /**
   * 无法编译成功，因为默认是不变的，只有在协变时才可以编译成功
   */
  private def func1: Unit = {
    /*val x: A02Queue[Any] = new StrangeIntQueue
    x.enqueue("abc")*/
  }
}

/*

class StrangeIntQueue extends A02Queue[Int] {
  override def head: Int = 1

  override def tail: A02Queue[Int] = A02Queue()

  override def enqueue(x: Int): A02Queue[Int] = {
    println(math.sqrt(x))
    super.enqueue(x)
  }
}
*/

