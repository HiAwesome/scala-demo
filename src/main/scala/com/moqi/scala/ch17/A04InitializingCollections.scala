package com.moqi.scala.ch17

import scala.collection.immutable.TreeSet
import scala.collection.mutable

/**
 * 初始化集合
 *
 * @author moqi On 11/11/20 10:33
 */
object A04InitializingCollections {

  def main(args: Array[String]): Unit = {

    // 手动指定与编译器推断不同的类型
    val stuff = mutable.Set[Any](42)
    stuff += "abcd"
    println(s"stuff = ${stuff}")
    println()

    // 使用别的集合初始化当前集合
    val colors = List("red", "yellow", "blue", "green")
    // val treeSet = TreeSet(colors)
    val treeSet = TreeSet[String]() ++ colors
    println(s"treeSet = ${treeSet}")
    println()

    // 转换成数组或者列表
    println(s"treeSet.toList = ${treeSet.toList}")
    println(s"treeSet.toArray = ${treeSet.toArray.mkString("Array(", ", ", ")")}")
    println()

    // 在可变和不可变之间转换
    val mutableTreeSet = mutable.Set.empty ++= treeSet
    println(s"mutableTreeSet = ${mutableTreeSet}")
    val immutableTreeSet = Set.empty ++ mutableTreeSet
    println(s"immutableTreeSet = ${immutableTreeSet}")

    val mutableMap = mutable.Map('i' -> 1, 'j' -> 2)
    println(s"mutableMap = ${mutableMap}")
    mutableMap += ('m' -> 100)
    println(s"mutableMap = ${mutableMap}")
    val immutableMap = Map.empty ++ mutableMap
    println(s"immutableMap = ${immutableMap}")
    println()

  }

}
