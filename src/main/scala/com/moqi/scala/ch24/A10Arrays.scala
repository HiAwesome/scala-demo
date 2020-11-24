package com.moqi.scala.ch24

import scala.collection.ArrayOps
import scala.reflect.ClassTag

/**
 * 数组
 *
 * @author moqi On 11/24/20 11:23
 */
object A10Arrays {

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

    func4

    func5

  }

  private def func5: Unit = {
    val w1 = wrap2(Vector(1, 2, 3))
    println(s"w1 = ${w1.mkString("Array(", ", ", ")")}")
    println()
  }

  def wrap2[U: ClassTag](xs: Vector[U]): Array[U] = evenElems(xs)

  /**
   * No ClassTag available for U
   *   def wrap[U](xs: Vector[U]): Array[U] = evenElems(xs)
   */
  private def func4: Unit = {
    /*val w1 = wrap(Vector(1, 2, 3))
    println(s"w1 = ${w1}")
    println()*/
  }

  // def wrap[U](xs: Vector[U]): Array[U] = evenElems(xs)

  private def func3: Unit = {
    println(s"evenElems(Vector(1, 2, 3, 4, 5)) = ${evenElems(Vector(1, 2, 3, 4, 5)).mkString("Array(", ", ", ")")}")
    val r1 = evenElems(Vector("this", "is", "a", "test", "run"))
    println(s"r1 = ${r1.mkString("Array(", ", ", ")")}")
    println()
  }

  /**
   * 这样可行
   * ClassTag 表示被擦除的类型
   */
  def evenElems[T: ClassTag](xs: Vector[T]): Array[T] = {
    val arr = new Array[T]((xs.length + 1) / 2)
    // 0 until xs.length 优化为 xs.indices
    for (i <- xs.indices by 2) arr(i / 2) = xs(i)
    arr
  }

  private def func2: Unit = {
    val a1: Array[Int] = Array(1, 2, 3)
    val seq: Seq[Int] = a1
    val a4: Array[Int] = seq.toArray
    println(s"a1 eq a4 = ${a1 eq a4}")
    println()

    println(s"seq.reverse = ${seq.reverse}")
    val ops: ArrayOps[Int] = a1
    println(s"ops.reverse = ${ops.reverse.mkString("Array(", ", ", ")")}")
    println()

    println(s"a1.reverse = ${a1.reverse.mkString("Array(", ", ", ")")}")
    println(s"intArrayOps(a1).reverse = ${intArrayOps(a1).reverse.mkString("Array(", ", ", ")")}")
    println()
  }

  private def func1: Unit = {
    val a1 = Array(1, 2, 3)
    println(s"a1 = ${a1.mkString("Array(", ", ", ")")}")
    val a2 = a1 map (_ * 3)
    println(s"a2 = ${a2.mkString("Array(", ", ", ")")}")
    val a3 = a2 filter (_ % 2 != 0)
    println(s"a3 = ${a3.mkString("Array(", ", ", ")")}")
    println(s"a3.reverse = ${a3.reverse.mkString("Array(", ", ", ")")}")
    println()
  }
}
