package com.moqi.scala.ch07

/**
 * 对指令式代码进行重构
 *
 * @author moqi On 11/3/20 09:51
 */
object A08RefactorTheImperativeCode {

  def main(args: Array[String]): Unit = {

    println(multiTable())

  }

  /**
   * 以序列形式返回一行
   */
  def makeRowSeq(row: Int): IndexedSeq[String] =
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }

  /**
   * 以字符串形式返回一行
   */
  def makeRow(row: Int): String = makeRowSeq(row).mkString

  /**
   * 以每行占一个文本行的字符串的形式返回表格
   * @return
   */
  def multiTable(): String = {
    // 行字符串的序列
    val tableSeq =
      for (row <- 1 to 10)
        yield makeRow(row)

    tableSeq.mkString("\n")
  }

}
