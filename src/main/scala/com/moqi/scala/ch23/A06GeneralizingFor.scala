package com.moqi.scala.ch23

/**
 * 泛化 for 表达式
 *
 * @author moqi On 11/23/20 11:33
 */
object A06GeneralizingFor {

  def main(args: Array[String]): Unit = {


  }

}

abstract class C[A] {
  def map[B](f: A => B): C[B]

  def flatMap[B](f: A => C[B]): C[B]

  def withFilter(p: A => Boolean): C[A]

  def foreach(b: A => Unit): Unit
}