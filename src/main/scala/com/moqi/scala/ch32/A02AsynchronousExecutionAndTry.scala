package com.moqi.scala.ch32

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * 异步执行和 Try
 *
 * @author moqi On 11/27/20 17:56
 */
object A02AsynchronousExecutionAndTry {

  def main(args: Array[String]): Unit = {

    func1

    val fut = Future {
      Thread.sleep(1000);
      21 / 0
    }
    runFuture(fut)

  }

  private def func1: Unit = {
    val fut = Future {
      Thread.sleep(1000);
      21 + 21
    }
    runFuture(fut)
  }

  private def runFuture(fut: Future[Int]): Unit = {
    println(s"fut.isCompleted = ${fut.isCompleted}")
    println(s"fut.value = ${fut.value}")
    Thread.sleep(2000)
    println(s"fut.isCompleted = ${fut.isCompleted}")
    println(s"fut.value = ${fut.value}")
    println()
  }
}
