package com.moqi.scala.ch21

/**
 * 隐式规则
 *
 * @author moqi On 11/20/20 09:29
 */
object A02RulesForImplicits {

  def main(args: Array[String]): Unit = {


  }

  /**
   * 隐式函数定义
   */
  implicit def intToString(x: Int) = x.toString

}

object MyConversions {

  implicit def stringWrapper(s: String): IndexedSeq[Char] = s.appended()

  implicit def intToString(x: Int): String = String.valueOf(x)

}