package com.moqi.scala.ch21

/**
 * 当有多个转换可选时
 *
 * @author moqi On 11/20/20 14:17
 */
object A07WhenMultipleConversionsApply {

  def printLength(seq: Seq[Int]) = println(seq.length)

  implicit def intToRange(i: Int) = 1 to i

  implicit def intToDigits(i: Int) = i.toString.toList.map(_.toInt)

  def main(args: Array[String]): Unit = {

    func1

    val b1 = "abc" == "abc".reverse.reverse
    println(s"b1 = ${b1}")

  }

  /**
   * type mismatch;
   *  found   : Int(12)
   *  required: Seq[Int]
   * Note that implicit conversions are not applicable because they are ambiguous:
   *  both method intToRange in object A07WhenMultipleConversionsApply of type (i: Int): scala.collection.immutable.Range.Inclusive
   *  and method intToDigits in object A07WhenMultipleConversionsApply of type (i: Int): List[Int]
   *  are possible conversion functions from Int(12) to Seq[Int]
   *     printLength(12)
   */
  private def func1: Unit = {
    //printLength(12)
  }
}


