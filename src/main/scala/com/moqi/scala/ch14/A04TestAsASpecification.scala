package com.moqi.scala.ch14

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.moqi.scala.ch14.AbstractElement.elem

/**
 * 作为规格说明的测试
 *
 * @author moqi On 11/6/20 19:32
 */
object A04TestAsASpecification {

}

class ElementSpec extends AnyFlatSpec with Matchers {

  "A UniformElement" should
    "have a width equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.width should be (2)
  }

  it should "have a height equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.height should be (3)
  }

  it should "throw an IAE if passed a negative width" in {
    an [IllegalArgumentException] should be thrownBy {
      elem('x', -2, 3)
    }
  }

}