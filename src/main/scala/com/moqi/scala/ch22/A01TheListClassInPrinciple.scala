package com.moqi.scala.ch22

/**
 * List 类的原理
 * Nil 继承自 List[Nothing]，所以 Nil 跟 List 类型的每个实例都兼容
 * :: 和 ::: 类都是向右绑定的
 *
 * @author moqi On 11/20/20 14:38
 */
object A01TheListClassInPrinciple {

  def main(args: Array[String]): Unit = {

    // List 是协变的
    val xs = List(1, 2, 3)
    val ys: List[Any] = xs
    println(s"ys = ${ys}")

  }

}
