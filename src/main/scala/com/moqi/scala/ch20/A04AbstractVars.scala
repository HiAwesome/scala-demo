package com.moqi.scala.ch20

/**
 * 抽象的 vars
 *
 * @author moqi On 11/12/20 17:37
 */
object A04AbstractVars {

  def main(args: Array[String]): Unit = {

    val time = new AbstractTime {
      override var hour: Int = 10
      override var minute: Int = 30
    }
    println(s"time = ${time}")

  }

}

/**
 * 声明抽象 var
 */
trait AbstractTime {
  var hour: Int
  var minute: Int

  override def toString: String = hour + "点" + minute + "分"
}

/**
 * 抽象的 var 是如何被展开成 getter 和 setter 的
 */
trait AbstractTime2 {
  def hour: Int

  def hour_=(x: Int)

  def minute: Int

  def minute_=(x: Int)
}