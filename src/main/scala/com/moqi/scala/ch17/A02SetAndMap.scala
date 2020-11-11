package com.moqi.scala.ch17

import scala.collection.immutable.{TreeSet, TreeMap}
import scala.collection.mutable

/**
 * Set 和 Map
 *
 * @author moqi On 11/11/20 09:34
 */
object A02SetAndMap {

  private val text = "See Spot run. Run, Spot, Run!"

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

    func4

    func5

    func6
  }

  /**
   * 排好序的 set 和 map，用红黑树实现排序
   */
  private def func6: Unit = {
    val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
    println(s"ts = ${ts}")
    val cs = TreeSet('f', 'u', 'n')
    println(s"cs = ${cs}")
    println()

    var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
    println(s"tm = ${tm}")
    tm += (2 -> 'x')
    println(s"tm = ${tm}")
    println()
  }

  /**
   * set 和 map 在五个元素之内，使用特定的类实现，在此数字之上使用哈希字典树为基础的数据结构
   */
  private def func5: Unit = {
    val s0 = Set()
    println(s"s0.getClass = ${s0.getClass}")
    val s1 = Set(1)
    println(s"s1.getClass = ${s1.getClass}")
    val s2 = Set(1, 2)
    println(s"s2.getClass = ${s2.getClass}")
    val s3 = Set(1, 2, 3)
    println(s"s3.getClass = ${s3.getClass}")
    val s4 = Set(1, 2, 3, 4)
    println(s"s4.getClass = ${s4.getClass}")
    val s5 = Set(1, 2, 3, 4, 5)
    println(s"s5.getClass = ${s5.getClass}")
    println()
  }

  private def func4: Unit = {
    val map = Map('i' -> 1, 'j' -> 2)
    println(s"map + ('m' -> 10) = ${map + ('m' -> 10)}")
    println(s"map - 'i' = ${map - 'i'}")
    println(s"map ++ List('a' -> 1, 'b' -> 10) = ${map ++ List('a' -> 1, 'b' -> 10)}")
    println(s"map -- List('a', 'b') = ${map -- List('a', 'b')}")
    println(s"map.size = ${map.size}")
    println(s"map('i') = ${map('i')}")
    println(s"map.keys = ${map.keys}")
    println(s"map.keySet = ${map.keySet}")
    println(s"map.values = ${map.values}")
    println(s"map.isEmpty = ${map.isEmpty}")
    println()

    val mutableMap = mutable.Map.empty[Char, Int]
    println(s"mutableMap += ('a' -> 100) = ${mutableMap += ('a' -> 100)}")
    println(s"mutableMap-= 'a' = ${mutableMap -= 'a'}")
    println(s"mutableMap ++= List('c' -> 10, 'd' -> 20, 'e' -> 1000) = ${mutableMap ++= List('c' -> 10, 'd' -> 20, 'e' -> 1000)}")
    println(s"mutableMap --= List('c', 'd') = ${mutableMap --= List('c', 'd')}")
    mutableMap.clear()
    println(s"mutableMap = ${mutableMap}")
    println()
  }

  private def func3: Unit = {
    val map1 = mutable.Map.empty[String, Int]
    map1("Hello") = 1
    map1("there") = 2
    println(s"map1 = ${map1}")
    println(s"map1(Hello) = ${map1("Hello")}")
    println()

    def countWords(text: String): mutable.Map[String, Int] = {
      val counts = mutable.Map.empty[String, Int]
      for (rawWord <- text.split("[ !,.]+")) {
        val word = rawWord.toLowerCase
        val oldCount =
          if (counts.contains(word)) counts(word)
          else 0
        counts += (word -> (oldCount + 1))
      }
      counts
    }

    println(s"countWords(text) = ${countWords(text)}")
    println()
  }

  private def func2: Unit = {
    val set = Set(1, 2, 3)
    println(s"set = ${set}")
    println(s"set + 5 = ${set + 5}")
    println(s"set - 3 = ${set - 3}")
    println(s"set ++ List(5, 6) = ${set ++ List(5, 6)}")
    println(s"set -- List(1, 2) = ${set -- List(1, 2)}")
    println(s"set & Set(1, 3, 5, 7) = ${set & Set(1, 3, 5, 7)}")
    println(s"set.size = ${set.size}")
    println(s"set.contains(3) = ${set.contains(3)}")
    println()

    val words = mutable.Set.empty[String]
    println(s"words += the = ${words += "the"}")
    println(s"words -= the = ${words -= "the"}")
    val v1 = words ++= List("do", "re", "mi")
    println(s"v1 = ${v1}")
    val v2 = words --= List("do", "re")
    println(s"v2 = ${v2}")
    words.clear()
    println(s"words = ${words}")
    println()
  }

  private def func1: Unit = {
    val mutableSet = mutable.Set(1, 2, 3)
    println(s"mutableSet = ${mutableSet}")
    val wordsArray = text.split("[ !,.]+")
    println(s"wordsArray = ${wordsArray.mkString("Array(", ", ", ")")}")
    val words = mutable.Set.empty[String]
    for (word <- wordsArray) words += word.toLowerCase
    println(s"words = ${words}")
    println()
  }
}
