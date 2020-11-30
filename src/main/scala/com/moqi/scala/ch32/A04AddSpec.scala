package com.moqi.scala.ch32

import org.scalatest.funspec.AsyncFunSpec

import scala.concurrent.Future

/**
 * 向 ScalaTest 返回 future 断言
 *
 * @author moqi On 11/30/20 15:44
 */
class A04AddSpec extends AsyncFunSpec {

  def addSoon(addends: Int*): Future[Int] = Future {
    addends.sum
  }

  describe("addSoon") {

    it("will eventually compute a sum of passed Ints") {
      val futureSum: Future[Int] = addSoon(1, 2)
      futureSum map { sum =>
        assert(sum == 3)
      }
    }

  }

}