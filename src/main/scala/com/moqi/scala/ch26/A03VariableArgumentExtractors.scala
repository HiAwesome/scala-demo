package com.moqi.scala.ch26

/**
 * 提起可变长度参数的模式
 *
 * @author moqi On 11/25/20 18:00
 */
object A03VariableArgumentExtractors {

  def main(args: Array[String]): Unit = {

    func1

    func2

  }

  private def func2: Unit = {
    val s = "tom@support.epfl.ch"
    val ExpandedEmail(name, topDom, subDoms@_*) = s
    println(s"name = ${name}")
    println(s"topDom = ${topDom}")
    println(s"subDoms = ${subDoms}")
    println()
  }

  private def func1: Unit = {
    val b1 = isTomInDotCom("tom@sun.com")
    val b2 = isTomInDotCom("peter@sum.com")
    val b3 = isTomInDotCom("tom@acm.org")
    println(s"b1 = ${b1}")
    println(s"b2 = ${b2}")
    println(s"b3 = ${b3}")
    println()
  }

  def isTomInDotCom(s: String): Boolean = s match {
    case Email("tom", Domain("com", _*)) => true
    case _ => false
  }

}

/**
 * Domain 字符串提取对象
 */
object Domain {

  /**
   * 注入方法（可选）
   */
  def apply(parts: String*): String = parts.reverse.mkString(".")

  /**
   * 提取方法（必选）
   */
  def unapplySeq(whole: String): Option[Seq[String]] =
    Some(whole.split("\\.").reverse)

}

/**
 * ExpandedEmail 字符串提取器对象
 */
object ExpandedEmail {

  def unapplySeq(email: String): Option[(String, Seq[String])] = {
    val parts = email split "@"
    if (parts.length == 2)
      Some(parts(0), parts(1).split("\\.").reverse)
    else
      None
  }

}
