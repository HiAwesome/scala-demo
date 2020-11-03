package com.moqi.scala.ch07

/**
 * 变量作用域
 *
 * @author moqi On 11/3/20 09:39
 */
object A07VariableScope {

  def main(args: Array[String]): Unit = {

    printMultiTable

    testInnerVariable

  }

  def testInnerVariable: Unit = {
    val a = 1;
    {
      val a = 2
      println(s"a = ${a}")
    }
    println(s"a = ${a}")
    println()
  }

  /**
   * 指令式风格打印乘法表
   */
  def printMultiTable: Unit = {
    var i = 1
    // 只有 i 在作用域内
    while (i <= 10) {
      var j = 1
      // i 和 j 在作用域内
      while (j <= 20) {
        val product = (i * j).toString
        // i, j, product 在作用域内
        var k = product.length
        // i, j, product, k 在作用域内
        while (k < 4) {
          print(" ")
          k += 1
        }

        print(product)
        j += 1
      }
      // i, j 在作用域内, product, k 超出了作用域
      println()
      i += 1
    }

    // i 在作用域内, j, product, k 超出了作用域
    println()
  }

}
