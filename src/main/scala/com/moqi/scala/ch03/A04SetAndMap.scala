package com.moqi.scala.ch03

/**
 * 使用 Set 和 Map
 *
 * @author moqi On 10/29/20 11:58
 */
object A04SetAndMap {

  def main(args: Array[String]): Unit = {

    var jetSet = Set("boeing", "airbus")
    jetSet += "lear"
    println(jetSet.contains("cessna"))

  }

}
