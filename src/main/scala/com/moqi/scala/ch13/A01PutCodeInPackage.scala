package com.moqi.scala.ch13

import com.moqi.scala.ch13.tom.smith.Navigator2

/**
 * 将代码放进包里
 *
 * @author moqi On 11/6/20 16:59
 */
object A01PutCodeInPackage {

  def main(args: Array[String]): Unit = {

    // toString 显示路径
    val n1 = new Navigator1
    println(s"n1 = ${n1}")
    val n2 = new Navigator2
    println(s"n2 = ${n2}")

  }

}

class Navigator1

package tom.smith {
  class Navigator2
}

/**
 * 包结构可以将某个类的测试代码和自身放在同一个文件，却分成不同的包
 */
package bob {
  package navigation {
    class Navigator3
    package tests {
      class Navigator3Test
    }
  }
}