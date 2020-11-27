package com.moqi.scala.ch30

/**
 * 为参数化类型定义相等性
 *
 * @author moqi On 11/27/20 11:38
 */
object A03DefiningEqualityForParameterizedTypes {

  def main(args: Array[String]): Unit = {


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
                ) extends Tree[T]