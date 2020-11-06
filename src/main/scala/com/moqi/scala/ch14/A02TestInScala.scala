package com.moqi.scala.ch14

import com.moqi.scala.ch14.AbstractElement.elem
import org.scalatest.funsuite.AnyFunSuite

/**
 * 用 Scala 写测试
 *
 * @author moqi On 11/6/20 17:57
 */
object A02TestInScala {

}

class ElementSuite extends AnyFunSuite {

  test("elem result should have passed width") {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
  }

}