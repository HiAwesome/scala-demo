package com.moqi.scala.ch18

import com.moqi.scala.ch18.MySimulation._

/**
 * 描述数字电路的语言 练习
 *
 * @author moqi On 11/11/20 15:28
 */
object A06Practice {

  def main(args: Array[String]): Unit = {

    val input1, input2, sum, carry = new Wire
    println(s"input1 = ${input1}")
    println(s"input2 = ${input2}")
    println(s"sum = ${sum}")
    println(s"carry = ${carry}")
    println()

    probe("sum", sum)
    probe("carry", carry)

    halfAdder(input1, input2, sum, carry)
    input1 setSignal true
    run()
    input2 setSignal true
    run()

  }

}
