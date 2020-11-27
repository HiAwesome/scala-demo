package com.moqi.scala.ch30

/**
 * 为参数化类型定义相等性
 *
 * @author moqi On 11/27/20 11:38
 */
object A03DefiningEqualityForParameterizedTypes {

  def main(args: Array[String]): Unit = {

    func1

  }

  /**
   * 类型被擦除，所以比较结果为 true
   */
  private def func1: Unit = {
    val b1 = new Branch[List[String]](Nil, EmptyTree, EmptyTree)
    val b2 = new Branch[List[Int]](Nil, EmptyTree, EmptyTree)
    println(s"b1 == b2 = ${b1 == b2}")
    println()
  }
}

/**
 * 二叉树的继承关系
 */
trait Tree[+T] {
  def elem: T

  def left: Tree[T]

  def right: Tree[T]
}

object EmptyTree extends Tree[Nothing] {
  override def elem: Nothing = throw new NoSuchElementException("EmptyTree.elem")

  override def left: Tree[Nothing] = throw new NoSuchElementException("EmptyTree.left")

  override def right: Tree[Nothing] = throw new NoSuchElementException("EmptyTree.right")
}

class Branch[+T](
                  val elem: T,
                  val left: Tree[T],
                  val right: Tree[T]
                ) extends Tree[T] {

  override def equals(other: Any): Boolean = other match {
    /**
     * 不用元素类型 T，用小写字母 t，模式中小写字母开始的类型参数表示未知的类型
     * 也可以被替换为下划线
     */
    case that: Branch[_] =>
      (that canEqual this) &&
      this.elem == that.elem &&
      this.left == that.left &&
      this.right == that.right
    case _ => false
  }

  override def hashCode(): Int = (elem, left, right).##

  /*def canEqual(other: Any): Boolean = other match {
    case _: Branch[_] => true
    case _ => false
  }*/

  /**
   * Branch[_] 是所谓的存在类型的简写，粗略地说这是一个通配类型
   */
  def canEqual(other: Any): Boolean = other.isInstanceOf[Branch[_]]

}