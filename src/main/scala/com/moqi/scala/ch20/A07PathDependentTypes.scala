package com.moqi.scala.ch20

/**
 * 路径依赖类型
 *
 * @author moqi On 11/16/20 09:35
 */
object A07PathDependentTypes {

}

class DogFood extends Food

class Dog extends Animal {
  override type SuitableFood = DogFood

  override def eat(food: DogFood): Unit = {}
}