package com.moqi.scala.ch09

/**
 * 传名参数
 *
 * @author moqi On 11/3/20 19:23
 */
object A05ByNameParameter {

  def main(args: Array[String]): Unit = {

    myAssert(() => 5 > 3)
    // 触发异常
    // myAssert(() => 5 < 3)

    byNameAssert(5 > 3)

    boolAssert(5 > 3)

    byNameAssert(5 / 0 == 0)

    boolAssert(5 / 0 == 0)

  }

  var assertionsEnable = true

  def myAssert(predicate: () => Boolean): Unit =
    if (assertionsEnable && !predicate())
      throw new AssertionError("断言失败")

  def byNameAssert(predicate: => Boolean): Unit =
    if (assertionsEnable && !predicate)
      throw new AssertionError("断言失败")

  /**
   * 这种方法会有副作用
   */
  def boolAssert(predicate: Boolean): Unit =
    if (assertionsEnable && !predicate)
      throw new AssertionError("断言失败")

}
