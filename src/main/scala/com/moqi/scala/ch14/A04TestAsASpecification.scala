package com.moqi.scala.ch14

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.moqi.scala.ch14.AbstractElement.elem
import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec

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
    ele.width should be(2)
  }

  it should "have a height equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.height should be(3)
  }

  it should "throw an IAE if passed a negative width" in {
    an[IllegalArgumentException] should be thrownBy {
      elem('x', -2, 3)
    }
  }

}

class TVSetSpec extends AnyFeatureSpec with GivenWhenThen {

  // 功能
  Feature("TV power button") {
    // 场景，given, when, then 为具体细节
    Scenario("User presser power button when TV is off") {
      Given("a TV set that is switched off")
      When("the power button is pressed")
      Then("the TV should switch on")
      // pending 表示还未实现，只是规格说明
      pending
    }
  }

}