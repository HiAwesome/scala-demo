package com.moqi.scala.ch20

/**
 * 路径依赖类型
 *
 * @author moqi On 11/16/20 09:35
 */
object A07PathDependentTypes {

  def main(args: Array[String]): Unit = {

    val o1 = new Outer
    val o2 = new o1.Inner
    println(s"o2 = ${o2}")

  }

}

class DogFood extends Food

class Dog extends Animal {
  override type SuitableFood = DogFood

  override def eat(food: DogFood): Unit = {}
}

class Outer {

  class Inner

}