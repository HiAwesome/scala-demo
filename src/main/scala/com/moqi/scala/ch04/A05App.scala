package com.moqi.scala.ch04

/**
 * App 特质
 *
 * @author moqi On 10/29/20 19:33
 */
object A05App extends App {

  for (season <- List("fall", "winter", "spring"))
    println(season + ": " + A03CheckSumAccumulator.calculate(season))

}
