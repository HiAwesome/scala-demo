package com.moqi.scala.ch03

import scala.collection.mutable
import scala.collection.immutable
/**
 * 使用 Set 和 Map
 *
 * @author moqi On 10/29/20 11:58
 */
object A04SetAndMap {

  def main(args: Array[String]): Unit = {

    set1

    movieSet1

    hashSet1

    map1

    map2

  }

  private def map2 = {
    val romanNumeral = Map(1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V")
    println(s"romanNumeral = ${romanNumeral}")
    println()
  }

  private def map1 = {
    val treasureMap = mutable.Map[Int, String]()
    treasureMap += (1 -> "Go to island.")
    treasureMap += (2 -> "Find big X on ground.")
    treasureMap += (3 -> "Dig.")
    println(treasureMap(2))
    println()
  }

  private def hashSet1 = {
    val hashSet = immutable.HashSet("Tomatoes", "Chilies")
    println(hashSet + "Coriander")
    println()
  }

  private def movieSet1 = {
    val movieSet = mutable.Set("Hitch", "Poltergeist")
    movieSet += "Shrek"
    println(s"movieSet = ${movieSet}")
    println()
  }

  private def set1 = {
    var jetSet = Set("Boeing", "Airbus")
    jetSet += "Lear"
    println(jetSet.contains("Cessna"))
    println()
  }

}
