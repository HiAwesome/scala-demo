package com.moqi.scala.ch21

/**
 * 上下文界定
 *
 * @author moqi On 11/20/20 11:44
 */
object A06ContextBounds {

  def main(args: Array[String]): Unit = {

    println(s"maxList3(List(1,4,7,3,6,0)) = ${maxList3(List(1, 4, 7, 3, 6, 0))}")

  }

  /**
   * 在内部使用隐式参数的函数
   */
  def maxList[T](elements: List[T])(implicit ordering: Ordering[T]): T = elements match {
    case List() => throw new IllegalArgumentException("empty list")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxList(rest) // 这里会隐式添加 ordering
      if (ordering.gt(x, maxRest)) x else maxRest // 这里的 ordering 依然是显式给出的
  }

  /**
   * 使用 implicitly 的函数
   * 完全没有用到 ordering 这个参数的名称
   */
  def maxList2[T](elements: List[T])(implicit ordering: Ordering[T]): T = elements match {
    case List() => throw new IllegalArgumentException("empty list")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxList2(rest)
      if (implicitly[Ordering[T]].gt(x, maxRest)) x else maxRest
  }

  /**
   * 带有上下文界定的函数
   */
  def maxList3[T: Ordering](elements: List[T]): T = elements match {
    case List() => throw new IllegalArgumentException("empty list")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxList3(rest)
      if (implicitly[Ordering[T]].gt(x, maxRest)) x else maxRest
  }

}
