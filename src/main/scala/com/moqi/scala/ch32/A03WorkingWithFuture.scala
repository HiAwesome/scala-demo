package com.moqi.scala.ch32

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import scala.concurrent.Promise

/**
 * 使用 Future
 *
 * @author moqi On 11/30/20 10:53
 */
object A03WorkingWithFuture {

  def main(args: Array[String]): Unit = {

    futureMap

    futureFor

    futureFactory

  }

  private def futureFactory: Unit = {
    val f1 = Future.successful(21 + 21)
    val f2 = Future.failed(new Exception("bummer!"))

    val f3 = Future.fromTry(Success(21 + 21))
    val f4 = Future.fromTry(Failure(new Exception("exception!")))
    println(s"f1 = ${f1}")
    println(s"f3 = ${f3}")
    println()

    val pro = Promise[Int]
    val fut = pro.future
    println(s"fut.value = ${fut.value}")
    pro.success(88)
    println(s"fut.value = ${fut.value}")
    println()
  }

  private def futureFor: Unit = {
    val fut1 = Future {
      Thread.sleep(1000)
      21 + 21
    }
    val fut2 = Future {
      Thread.sleep(1000)
      23 + 23
    }

    val sum1 = for {
      x <- fut1
      y <- fut2
    } yield x + y
    Thread.sleep(2000)
    println(s"sum1 = ${sum1}")
    println()

    // 如果不在 for 表达式之前创建 future，则它们不会并行运行
    val sum2 = for {
      x <- Future {
        Thread.sleep(1000)
        21 + 21
      }
      y <- Future {
        Thread.sleep(1000)
        23 + 23
      }
    } yield x + y
    Thread.sleep(2000)
    println(s"sum2 = ${sum2}")
    Thread.sleep(2000)
    println(s"sum2 = ${sum2}")
    println()
  }

  private def futureMap: Unit = {
    val fut = Future {
      Thread.sleep(1000)
      21 + 21
    }

    val result = fut.map(x => x + 1)
    Thread.sleep(2000)
    println(s"result.value = ${result.value}")
    println()
  }
}

/**
 * 放在上面的 object 中运行异常
 * 单独开辟一个 object
 */
object FilterCollect1 extends App {

  val fut = Future.successful(1000)
  val valid = fut.filter(res => res > 0)
  println(s"valid.value = ${valid.value}")
  println()
  val invalid = fut.filter(res => res < 0)
  println(s"invalid.value = ${invalid.value}")
  println()

  val valid1 = for (res <- fut if res > 0) yield res
  println(s"valid1.value = ${valid1.value}")
  val invalid1 = for (res <- fut if res < 0) yield res
  println(s"invalid1.value = ${invalid1.value}")
  println()

}

object FilterCollect2 extends App {

  val fut1 = Future.successful(1000)

  val valid1 = fut1 collect {
    case res if res > 0 => res + 46
  }
  println(s"valid1.value = ${valid1.value}")
  println()

  val invalid2 = fut1 collect {
    case res if res < 0 => res + 99
  }
  println(s"invalid2.value = ${invalid2.value}")
  println()

}

/**
 * fixme recovered 及其之后的几个 value 稍有不同
 */
object HandleFailed extends App {
  val failure = Future {
    42 / 0
  }
  println(s"failure.value = ${failure.value}")
  println()

  val expectedFailure = failure.failed
  println(s"expectedFailure = ${expectedFailure}")
  println()

  val success = Future {
    42 / 1
  }
  println(s"success.value = ${success.value}")
  println()

  val unexpectedSuccess = success.failed
  println(s"unexpectedSuccess = ${unexpectedSuccess}")
  println()

  val fallback = failure.fallbackTo(success)
  println(s"fallback.value = ${fallback.value}")
  println()

  val failedFallback = failure.fallbackTo(
    Future {
      val res = 42
      require(res < 0)
      res
    }
  )
  println(s"failedFallback.value = ${failedFallback.value}")
  println()

  val recovered = failedFallback recover {
    case _: ArithmeticException => -1
  }
  println(s"recovered.value = ${recovered.value}")
  println()

  val unRecovered = fallback recover{
    case _: ArithmeticException => -1
  }
  println(s"unRecovered.value = ${unRecovered.value}")
  println()

  val alsoUnRecovered = failedFallback recover {
    case _: IllegalArgumentException => -2
  }
  println(s"alsoUnRecovered.value = ${alsoUnRecovered.value}")
  println()

  val alsoRecovered = failedFallback recoverWith {
    case _: ArithmeticException => Future {
      100 + 200
    }
  }
  println(s"alsoRecovered.value = ${alsoRecovered.value}")
  println()

  val first = success.transform(
    res => res * -1,
    ex => new Exception("see cause", ex)
  )
  println(s"first.value = ${first.value}")
  println()

  val second = failure.transform(
    res => res * -1,
    ex => new Exception("see cause", ex)
  )
  println(s"second.value = ${second.value}")
  println()

  val firstCase = success.transform {
    case Success(res) => Success(res * -1)
    case Failure(ex) => Failure(new Exception("see cause", ex))
  }
  println(s"firstCase.value = ${firstCase.value}")
  println()

  val secondCase = failure.transform {
    case Success(res) => Success(res * -1)
    case Failure(ex) => Failure(new Exception("see cause", ex))
  }
  println(s"secondCase = ${secondCase}")
  println()

  val nonNegative = failure.transform {
    case Success(res) => Success(res.abs + 1)
    case Failure(_) => Success(0)
  }
  println(s"nonNegative.value = ${nonNegative.value}")
  println()

  val zippedSuccess = success zip recovered
  println(s"zippedSuccess = ${zippedSuccess}")
  println()

  val zippedFailure = success zip failure
  println(s"zippedFailure = ${zippedFailure}")
  println()

  val fortyTwo = Future {21 + 21}
  val fortySix = Future {23 + 23}
  val futureNums = List(fortyTwo, fortySix)
  val folded = Future.foldLeft(futureNums)(0) {
    (acc, num) => acc + num
  }
  println(s"folded.value = ${folded.value}")
  println()

  val reduced = Future.reduceLeft(futureNums) {
    (acc, num) => acc + num
  }
  println(s"reduced.value = ${reduced.value}")
  println()

  val futureList = Future.sequence(futureNums)
  println(s"futureList.value = ${futureList.value}")
  println()

  val traversed = Future.traverse(List(1, 2, 3)) {i => Future(i)}
  println(s"traversed.value = ${traversed.value}")
  println()

  failure.foreach(ex => println(ex))
  println()

  success.foreach(ex => println(ex))
  println()

  for (res <- failure) println(res)
  println()

  for (res <- success) println(res)
  println()

  success onComplete {
    case Success(res) => println(res)
    case Failure(ex) => println(ex)
  }
  println()

  failure onComplete {
    case Success(res) => println(res)
    case Failure(ex) => println(ex)
  }
  println()

  val newFuture = success andThen {
    case Success(res) => println(res)
    case Failure(ex) => println(ex)
  }
  println()

  val nestedFuture = Future { Future {900}}
  val flatted = nestedFuture.flatten
  println()

  val futNum = Future {88 + 88}
  val futStr = Future {"ans" + "wer"}
  val zipped = futNum zip futStr
  val mapped = zipped map {
    case (num, str) => s"$num is the $str"
  }
  println(s"mapped.value = ${mapped.value}")
  println()

  val fut = futNum.zipWith(futStr) {
    case (num, str) => s"$num is the $str"
  }
  println(s"fut.value = ${fut.value}")
  println()

  val flipped = success.transformWith {
    case Success(res) => Future {
      throw new Exception(res.toString)
    }
    case Failure(_) => Future{900 + 1000}
  }
  println(s"flipped.value = ${flipped.value}")
  println()
}