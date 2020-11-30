package com.moqi.scala.ch32

import concurrent.{Await, Future}
import concurrent.duration._
import org.scalatest.matchers.should.Matchers._
import org.scalatest.concurrent.ScalaFutures._
import scala.concurrent._
import ExecutionContext.Implicits.global

/**
 * 测试 Future
 *
 * @author moqi On 11/30/20 15:31
 */
object A04TestingWithFuture {


  def main(args: Array[String]): Unit = {

    val fut = Future {
      Thread.sleep(1000)
      99 + 99
    }
    val x = Await.result(fut, 3.second)
    println(s"x = ${x}")
    println()

    val res = x should be(198)
    println(s"res = ${res}")
    println()

    val fut1 = Future {
      Thread.sleep(1000)
      66 + 1
    }
    Thread.sleep(2000)
    val test = fut1.futureValue should be(67)
    println(s"test = ${test}")
    println()
  }

}
