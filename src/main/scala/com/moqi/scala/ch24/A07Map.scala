package com.moqi.scala.ch24

/**
 * Map
 *
 * @author moqi On 11/23/20 16:53
 */
object A07Map {

  val cache = collection.mutable.Map[String, String]()

  def main(args: Array[String]): Unit = {

    println(cachedF("abc"))
    println(cachedF("abc"))
    println()

    println(cachedF2("jkl"))
    println(cachedF2("jkl"))
    println()

  }

  def cachedF(s: String) = cache.getOrElseUpdate(s, f(s))

  def cachedF2(s: String) = cache get s match {
    case Some(result) => result
    case None =>
      val result = f(s)
      cache(s) = result
      result
  }

  def f(x: String) = {
    println("taking my time.")
    Thread.sleep(100)
    x.reverse
  }

}
