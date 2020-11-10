package com.moqi.scala.ch16

/**
 * List 对象的方法
 *
 * @author moqi On 11/10/20 17:04
 */
object A08MethodsOfTheListObject {

  def main(args: Array[String]): Unit = {

    // 从元素创建列表：List.apply
    println(s"List.apply(1, 2, 3) = ${List.apply(1, 2, 3)}")
    println(s"List(1, 2, 3) == List.apply(1, 2, 3) = ${List(1, 2, 3) == List.apply(1, 2, 3)}")
    println()

    // 创建数值区间：List.range
    println(s"List.range(1, 5) = ${List.range(1, 5)}")
    println(s"List.range(1, 9, 2) = ${List.range(1, 9, 2)}")
    println(s"List.range(9, 1, -3) = ${List.range(9, 1, -3)}")
    println()

    // 创建相同元素的列表：List.fill
    println(s"List.fill(5)('a') = ${List.fill(5)('a')}")
    println(s"List.fill(3)(100) = ${List.fill(3)(100)}")
    println(s"List.fill(2, 3)('m') = ${List.fill(2, 3)('m')}")
    println()

    // 表格化一个函数：List.tabulate
    val squares = List.tabulate(5)(n => n * n)
    println(s"squares = ${squares}")
    val multiplication = List.tabulate(5, 5)(_ * _)
    println(s"multiplication = ${multiplication}")
    println()

    // 拼接多个列表：List.concat
    println(s"List.concat(List(1, 2), List(3, 4)) = ${List.concat(List(1, 2), List(3, 4))}")
    println(s"List.concat(List(), List(1), List(9)) = ${List.concat(List(), List(1), List(9))}")
    println(s"List.concat() = ${List.concat()}")
    println()

  }

}
