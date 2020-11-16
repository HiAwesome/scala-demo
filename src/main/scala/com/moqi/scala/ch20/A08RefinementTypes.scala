package com.moqi.scala.ch20

/**
 * 改良类型
 *
 * @author moqi On 11/16/20 09:42
 */
object A08RefinementTypes {

}

/**
 * 牧场里有一群食草动物
 */
class Pasture {
  var animals: List[Animal {type SuitableFood = Grass}] = Nil
}