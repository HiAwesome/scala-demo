package com.moqi.scala.ch23

/**
 * N 皇后问题
 *
 * @author moqi On 11/23/20 10:15
 */
object A02TheNQueensProblem {

  def main(args: Array[String]): Unit = {

    val q8: List[List[(Int, Int)]] = queens(8)
    for (res <- q8) println(s"res = ${res}")

  }

  def queens(n: Int): List[List[(Int, Int)]] = {

    def placeQueens(k: Int): List[List[(Int, Int)]] =
      if (k == 0) List(List())
      else
        for {
          queens <- placeQueens(k - 1)
          column <- 1 to n
          queen = (k, column)
          if isSafe(queen, queens)
        } yield queen :: queens

    placeQueens(n)
  }

  def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
    queens forall (q => !inCheck(queen, q))

  def inCheck(q1: (Int, Int), q2: (Int, Int)): Boolean =
    q1._1 == q2._1 || // 同一行
      q1._2 == q2._2 || // 同一列
      (q1._1 - q2._1).abs == (q1._2 - q2._2).abs // 斜线

}
