package com.moqi.scala.ch13

/**
 * 导入
 *
 * @author moqi On 11/6/20 17:08
 */
object A03Import {


  // 单类型引入

  import bobs.Fruit
  // 按需引入
  import bobs._
  // 静态字段引入
  import bobs.Fruits._

  def showFruit(fruit: Fruit) = {
    import fruit._
    // name 和 color 引入
    println(name + "'s are" + color)
  }

  // 引入一个包名

  import java.util.regex

  val pat = regex.Pattern.compile("a*b")

  // 引入两个成员

  import Fruits.{Apple, Orange}
  // 引入两个成员，Apple 被重命名为 McIntosh
  import Fruits.{Apple => McIntosh, Orange}

  // Date 被重命名为 SDate
  import java.util.{Date => SDate}

  // util 被重命名为 U
  import java.{util => U}

  // 等于 import Fruits._
  import Fruits.{_}

  // 导入 Fruits 所有成员，Apple 被重命名为 McIntosh
  import Fruits.{Apple => McIntosh, _}

  // 导入 Fruits 除了 Pear 之外的所有成员
  import Fruits.{Pear => _, _}

  // 等于 import Fruits.Apple
  import Fruits.{Apple}

  def main(args: Array[String]): Unit = {

    for (fruit <- Fruits.menu)
      showFruit(fruit)
    println()

    println(s"new SDate() = ${new SDate()}")
    println()

    println(s"new U.Date() = ${new U.Date()}")
    println()

  }


}

package bobs {

  abstract class Fruit(val name: String, val color: String)

  object Fruits {

    object Apple extends Fruit("apple", "red")

    object Orange extends Fruit("orange", "orange")

    object Pear extends Fruit("pear", "yellowish")

    val menu = List(Apple, Orange, Pear)
  }

}