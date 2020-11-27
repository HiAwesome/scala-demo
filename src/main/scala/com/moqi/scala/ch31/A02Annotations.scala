package com.moqi.scala.ch31

/**
 * 注解
 *
 * @author moqi On 11/27/20 15:37
 */
object A02Annotations {

  def main(args: Array[String]): Unit = {

    for {
      method <- Tests.getClass.getMethods
      if method.getName.startsWith("test")
      if method.getAnnotation(classOf[Ignore]) == null
    } {
      println("found a test method: " + method)
    }

  }

}

object Tests {

  @Ignore
  def testData = List(0, 1, -1, 5, -5)

  def test1: Unit = {
    assert(testData == (testData.head :: testData.tail))
  }

  def test2: Unit = {
    assert(testData.contains(testData.head))
  }

}