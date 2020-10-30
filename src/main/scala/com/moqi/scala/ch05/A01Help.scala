package com.moqi.scala.ch05

/**
 * 多行打印
 *
 * @author moqi On 10/30/20 17:14
 */
object A01Help extends App {

  println(
    """Welcome to Ultamix 3000.
    type "help" for help.""")

  println(
    """|Welcome to Ultamix 3000.
       |type "help" for help.""".stripMargin)


}
