package com.moqi.scala.ch27

import annotation._

/**
 * 注解的语法
 *
 * @author moqi On 11/26/20 10:49
 */

class strategy(arg: Annotation) extends Annotation

class delayed extends Annotation

object A02SyntaxOfAnnotations {

  def main(args: Array[String]): Unit = {


  }

  /**
   * 不能把注解当作一个注解的入参
   * @strategy(@delayed) def f() = {}
   */
  @strategy(new delayed) def f() = {}

}
