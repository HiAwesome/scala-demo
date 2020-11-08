package com.moqi.scala.ch14

import com.moqi.scala.ch14.AbstractElement.elem
import org.scalatest.matchers.must.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * 基于性质的测试
 * 模拟书中示例代码 14.7 发生编译错误，forAll 无法编译通过
 *
 * Scala 编程第三版第十四节地址
 *  https://booksites.artima.com/programming_in_scala_3ed/examples/html/ch14.html#sec5
 * Scala 编程第四版第十四节地址
 *  https://booksites.artima.com/programming_in_scala_4ed/examples/html/ch14.html#sec5
 *
 * 根据第四版的代码，引入 scalatestplus-scalacheck_2.13 依赖解决问题
 *
 * 注意，第四版代码中 elem 第二个参数和最终 equal 的对象为 w % 100 而不是 w,
 * 实测 w 会导致这个方法 OOM
 *
 * @author moqi On 11/8/20 09:51
 */
object A05PropertyBasedTesting {

}

class A05ElementSpec extends AnyWordSpec with ScalaCheckPropertyChecks {

  "elem result" must {
    "have passed width" in {
      forAll { (w: Int) =>
        whenever(w > 0) {
          elem('x', w % 100, 3).width must equal(w % 100)
        }
      }
    }
  }

}
