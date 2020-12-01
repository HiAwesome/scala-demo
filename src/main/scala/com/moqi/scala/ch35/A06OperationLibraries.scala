package com.moqi.scala.ch35

/**
 * 操作类库
 *
 * @author moqi On 12/1/20 10:03
 */
object A06OperationLibraries {

}

trait Arithmetic {
  this: Evaluator =>
  operations ++= List(
    "add" -> { case List(x, y) => x + y },
    "sub" -> { case List(x, y) => x - y },
    "div" -> { case List(x, y) => x / y },
    "mul" -> { case List(x, y) => x * y },
    "mod" -> { case List(x, y) => x % y },
    "sum" -> { xs => xs.foldLeft(0.0)(_ + _) },
    "prod" -> { xs => xs.foldLeft(1.0)(_ * _) }
  )
}
