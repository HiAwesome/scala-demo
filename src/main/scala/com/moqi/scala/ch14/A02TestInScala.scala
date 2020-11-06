package com.moqi.scala.ch14

import com.moqi.scala.ch14.AbstractElement.elem
import org.scalatest.funsuite.AnyFunSuite

/**
 * 用 Scala 写测试
 * Scala 的 FunSuite 已经更新为 AnyFunSuite 了，具体参考 https://stackoverflow.com/a/62680204
 * Scala Test 3.2 进行的 API 更新参考这里 https://www.scalatest.org/release_notes/3.2.0#expiredDeprecations
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