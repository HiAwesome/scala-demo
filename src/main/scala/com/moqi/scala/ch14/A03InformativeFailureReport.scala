package com.moqi.scala.ch14

import com.moqi.scala.ch14.AbstractElement.elem
import org.scalatest.funsuite.AnyFunSuite

/**
 * 翔实的失败报告
 *
 * @author moqi On 11/6/20 19:22
 */
object A03InformativeFailureReport {

}

class A03Test extends AnyFunSuite {

  test("3 == 2") {
    val width = 3
    assert(width == 2)
  }

  test("list contains") {
    assert(List(1, 2, 3).contains(4))
  }

  test("assert Result") {
    assertResult(2) {
      2
    }
  }

  test("illegal Argument Exception") {
    assertThrows[IllegalArgumentException] {
      elem('x', -2, 3)
    }
  }

  test("Arithmetic Exception") {
    assertThrows[ArithmeticException] {
      1 / 0
    }
  }

}