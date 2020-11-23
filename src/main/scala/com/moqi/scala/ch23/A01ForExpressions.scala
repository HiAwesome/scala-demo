package com.moqi.scala.ch23

/**
 * for 的例子
 *
 * @author moqi On 11/20/20 16:47
 */
object A01ForExpressions {

  def main(args: Array[String]): Unit = {

    func1

    val newList = for (x <- List(1, 2); y <- List("one", "two")) yield (x, y)
    println(s"newList = ${newList}")
    println()

  }

  private def func1: Unit = {
    val lara = Person("Lara", isMale = false)
    val bob = Person("Bob", isMale = true)
    val julie = Person("Julie", false, lara, bob)
    val persons = List(lara, bob, julie)
    println(s"persons = ${persons}")
    println()

    val momChild = persons filter (p => !p.isMale) flatMap (p => p.children map (c => (p.name, c.name)))
    println(s"momChild = ${momChild}")
    println()

    val momChild2 = persons withFilter (p => !p.isMale) flatMap (p => p.children map (c => (p.name, c.name)))
    println(s"momChild2 = ${momChild2}")
    println()

    // 所有最终交出 yield 结果的 for 表达式都会被编译器翻译成对高阶函数 map、flatMap 和 withFilter 的调用
    // 所有不带 yield 的 for 循环会被翻译成更小集的高阶函数：只有 withFilter 和 foreach
    val momChild3 = for (p <- persons; if !p.isMale; c <- p.children) yield (p.name, c.name)
    println(s"momChild3 = ${momChild3}")
    println()
  }
}

case class Person(name: String, isMale: Boolean, children: Person*)