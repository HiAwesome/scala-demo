package com.moqi.scala.ch26

/**
 * 提取器
 *
 * @author moqi On 11/25/20 16:32
 */
object A02Extractors {

  def main(args: Array[String]): Unit = {



  }

}

object Email {

  def main(args: Array[String]): Unit = {

    val b1 = unapply("tom@gmail.com") equals Some("tom", "gmail.com")
    println(s"b1 = ${b1}")
    val b2 = unapply("John Doe").isEmpty
    println(s"b2 = ${b2}")

  }

  /**
   * 注入方法（可选）
   */
  def apply(user: String, domain: String): String = user + "@" + domain

  /**
   * 提取方法（必选）
   */
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }

}