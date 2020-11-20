package com.moqi.scala.ch21

/**
 * 隐式转换的调试
 *
 * @author moqi On 11/20/20 14:24
 */
object A08DebuggingImplicits {

  def main(args: Array[String]): Unit = {

    // val chars: List[Char] = "xyz"
    // val chars: List[Char] = wrapString("xyz")

  }

}

/**
 * 使用隐式转换的代码示例
 */
object Mocha extends App {

  class PreferredDrink(val preference: String)

  implicit val pref = new PreferredDrink("mocha")

  def enjoy(name: String)(implicit drink: PreferredDrink) = {
    println("Welcome, " + name)
    print(". Enjoy a ")
    print(drink.preference)
    println("!")
  }

  enjoy(("reader"))

}