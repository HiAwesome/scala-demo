package com.moqi.scala.ch19

/**
 * 信息隐藏
 *
 * @author moqi On 11/11/20 19:02
 */
object A02InformationHiding {

  def main(args: Array[String]): Unit = {

    // Queue 为自定义的 Queue
    val q = Queue(1, 2, 3)
    println(s"q = ${q}")
    val q1 = q enqueue 4
    println(s"q1 = ${q1}")
    println(s"q = ${q}")
    println()

  }

}
