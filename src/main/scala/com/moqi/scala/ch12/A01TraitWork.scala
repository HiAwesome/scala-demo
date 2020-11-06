package com.moqi.scala.ch12

/**
 * 特质如何工作
 *
 * @author moqi On 11/6/20 14:58
 */
object A01TraitWork {

  def main(args: Array[String]): Unit = {

    val frog = new A01Frog
    frog.philosophize()
    val phil: A01Philosophical = frog
    phil.philosophize()
    println()

    val phil2: A01Philosophical = new A01Frog2
    phil2.philosophize()

  }

}

trait A01Philosophical {

  def philosophize(): Unit = println("I consume memory, therefore I am!")

}

/**
 * 用 extends 混入特质
 */
class A01Frog extends A01Philosophical {
  override def toString: String = "green"
}

class A01Animal

/**
 * 用 with 混入特质
 */
class A01Frog2 extends A01Animal with A01Philosophical {
  override def toString: String = "green"

  override def philosophize(): Unit = println("It ain't easy being " + toString + "!")
}

trait A01HasLegs

/**
 * 用 extends 混入多个特质
 */
class A01Frog3 extends A01Animal with A01Philosophical with A01HasLegs {
  override def toString: String = "green"
}