package com.moqi.scala.ch20

/**
 * 抽象类型
 *
 * @author moqi On 11/16/20 09:28
 */
object A06AbstractType {

  def main(args: Array[String]): Unit = {

    /**
     * type mismatch;
     *  found   : com.moqi.scala.ch20.Fish
     *  required: bessy.SuitableFood
     *     bessy eat (new Fish)
     */
    /*val bessy: Animal = new Cow
    bessy eat (new Fish)*/

  }

}

class Food

/**
 * 用抽象类型对合适的食物建模
 */
abstract class Animal {
  type SuitableFood <: Food

  def eat(food: SuitableFood)
}

class Grass extends Food

/**
 * 在子类中实现抽象类型
 */
class Cow extends Animal {
  override type SuitableFood = Grass

  override def eat(food: Grass): Unit = {}
}

class Fish extends Food