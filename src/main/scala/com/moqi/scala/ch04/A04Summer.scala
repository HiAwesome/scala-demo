package com.moqi.scala.ch04

/**
 * Scala 应用程序
 *
 * @author moqi On 10/29/20 19:27
 */
object A04Summer {

  def main(args: Array[String]): Unit = {

    for (arg <- args)
      println(arg + ": " + A03CheckSumAccumulator.calculate(arg))

  }

}
