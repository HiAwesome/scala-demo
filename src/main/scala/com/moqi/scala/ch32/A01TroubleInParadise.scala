package com.moqi.scala.ch32

/**
 * 天堂里的烦恼
 *
 * @author moqi On 11/27/20 17:46
 */
object A01TroubleInParadise {

  var counter = 0

  synchronized {
    // 这里每次都只有一个线程在执行
    counter += 1
  }

  def main(args: Array[String]): Unit = {

    println(s"counter = ${counter}")

  }

}
