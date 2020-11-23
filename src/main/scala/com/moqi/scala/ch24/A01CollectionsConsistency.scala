package com.moqi.scala.ch24

import com.moqi.scala.ch20._

import scala.collection.immutable.{HashMap, LinearSeq, SortedSet}
import scala.collection.mutable

/**
 * 集合的一致性
 *
 * @author moqi On 11/23/20 11:44
 */
object A01CollectionsConsistency {

  def main(args: Array[String]): Unit = {

    func1

    func2

    println(s"List(1, 2, 3) map (_ + 1) = ${List(1, 2, 3) map (_ + 1)}")
    println(s"Set(1, 2, 3) map (_ * 2) = ${Set(1, 2, 3) map (_ * 2)}")

  }

  private def func2: Unit = {
    List(1, 2, 3)
    HashMap("x" -> 24, "y" -> 25, "z" -> 26)
  }

  private def func1: Unit = {
    Iterable("x", "y", "z")
    Map("x" -> 24, "y" -> 25, "z" -> 26)
    Set(Color.Red, Color.Green, Color.Blue)
    SortedSet("hello", "world")
    mutable.Buffer("x", "y", "z")
    IndexedSeq("x", "y", "z")
    LinearSeq("x", "y", "z")
  }
}
