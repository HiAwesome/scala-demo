package com.moqi.scala.ch31

import java.util

import scala.collection.mutable
/**
 * 通配类型
 *
 * @author moqi On 11/27/20 16:09
 */
object A03WildcardTypes {

  def main(args: Array[String]): Unit = {

    val contents: util.Collection[_] = func1

    func2(contents)

  }

  private def func2(contents: util.Collection[_]): Unit = {
    val sset = javaSet2ScalaSet(contents)
    println(s"sset.set = ${sset.set}")
    println()
  }

  private def func1: util.Collection[_] = {
    val contents = (new Wild).contents()
    println(s"contents = ${contents}")
    println(s"contents.size() = ${contents.size()}")
    println()
    contents
  }

  def javaSet2ScalaSet[T](jset: util.Collection[T]): SetAndType = {
    // 现在我们可以用 T 来表示这个类型了
    val sset = mutable.Set.empty[T]
    val iter = jset.iterator()

    while (iter.hasNext) sset += iter.next()

    new SetAndType {
      override type Elem = T
      override val set = sset
    }
  }

}

abstract class SetAndType {

  type Elem
  val set: mutable.Set[Elem]

}
