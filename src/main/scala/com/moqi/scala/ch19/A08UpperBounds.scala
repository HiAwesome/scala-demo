package com.moqi.scala.ch19

/**
 * 上界
 *
 * @author moqi On 11/12/20 11:26
 */
object A08UpperBounds {

  def main(args: Array[String]): Unit = {

    func1

    func2

  }

  private def func2: Unit = {
    val people = List(
      new Person("Tom", "Smith"),
      new Person("Guido", "Smith"),
      new Person("Yukihiro", "Smith"),
      new Person("Andy", "Smith"),
      new Person("Nike", "Smith"),
    )
    println(s"people = ${people}")

    val sortedPeople = orderMergeSort(people)
    println(s"sortedPeople = ${sortedPeople}")
    println()

    // 可以编译通过，但会运行报错 inferred type arguments [Int] do not conform to method orderMergeSort's type parameter bounds [T <: Ordered[T]]
    //    val wontCompile = orderMergeSort(List(3, 2, 1))
    val wontCompile = orderMergeSort(List(3, 2, 1))
    println(s"wontCompile = ${wontCompile}")
  }

  /**
   * 带有上界的归并排序函数
   * T <: Ordered[T] 这样的语法，告诉编译器参数类型 T 有一个上界 Ordered[T]
   */
  def orderMergeSort[T <: Ordered[T]](xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (as, bs) = xs splitAt n
      merge(orderMergeSort(as), orderMergeSort(bs))
    }
  }

  private def func1: Unit = {
    val robert = new Person("Robert", "Jones")
    val sally = new Person("Sally", "Smith")
    println(s"robert < sally = ${robert < sally}")
    println()
  }
}

/**
 * 混入了 Ordered 特质的 Person 类
 */
class Person(val firstName: String, val lastName: String) extends Ordered[Person] {
  override def compare(that: Person): Int = {
    val lastNamComparison = lastName.compareToIgnoreCase(that.lastName)

    if (lastNamComparison != 0) lastNamComparison
    else firstName.compareToIgnoreCase(that.firstName)
  }

  override def toString: String = firstName + " " + lastName
}