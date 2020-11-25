package com.moqi.scala.ch26

/**
 * 提取 0 或 1 个变量的模式
 *
 * @author moqi On 11/25/20 17:48
 */
object A02PatternsWithZeroOrOneVariables {

  def main(args: Array[String]): Unit = {

    val u1 = userTwiceUpper("DIDI@hotmail.com")
    val u2 = userTwiceUpper("DIDO@hotmail.com")
    val u3 = userTwiceUpper("didi@hotmail.com")
    println(s"u1 = ${u1}, u2 = ${u2}, u3 = ${u3}")
    println()

  }

  def userTwiceUpper(s: String): String = s match {
    // 匹配所有用户名部分连续出现两次全大写的同一个字符串的电子邮件地址的字符串
    case Email(Twice(x@UpperCase()), domain) =>
      "match: " + x + " in domain " + domain
    case _ => "no match"
  }

}

/**
 * Twice 字符串提取器对象
 */
object Twice {

  def apply(s: String): String = s + s

  def unapply(s: String): Option[String] = {
    val length = s.length / 2
    val half = s.substring(0, length)
    if (half == s.substring(length)) Some(half) else None
  }

}

/**
 * UpperCase 字符串提取器对象
 */
object UpperCase {
  def unapply(s: String): Boolean = s.toUpperCase == s
}