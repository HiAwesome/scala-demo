package com.moqi.scala.ch16


/**
 * List 类的初阶方法
 * 如果一个方法不接收任何参数作为入参，就被称为初阶方法
 *
 * @author moqi On 11/10/20 11:06
 */
object A06FirstOrderMethodsOnClassList {

  private val abcde = List('a', 'b', 'c', 'd', 'e')
  private val fruit = List("apple", "orange", "pears")

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

    func4

    func5

    func6

    func7

    func8

    func9

    func10

    func11

    func12

  }

  private def func12: Unit = {
    println(s"msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3)) = ${msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3))}")
    println(s"msort((x: Int, y: Int) => x > y)(List(5, 7, 1, 3)) = ${msort((x: Int, y: Int) => x > y)(List(5, 7, 1, 3))}")
    println()

    val intSort = msort((x: Int, y: Int) => x < y) _
    println(s"intSort = ${intSort}")
    val reverseIntSort = msort((x: Int, y: Int) => x > y) _
    println(s"reverseIntSort = ${reverseIntSort}")
    println()

    val mixedInts = List(4, 1, 9, 0, 5, 8, 3, 6, 2, 7)
    println(s"mixedInts = ${mixedInts}")
    println(s"intSort(mixedInts) = ${intSort(mixedInts)}")
    println(s"reverseIntSort(mixedInts) = ${reverseIntSort(mixedInts)}")
    println()
  }

  /**
   * 例子：归并排序
   * 使用函数柯里化从而使得比较方法和 List 得以区分
   */
  def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {

    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (less(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (as, bs) = xs splitAt n
      merge(msort(less)(as), msort(less)(bs))
    }

  }

  /**
   * 转换列表：iterator、toArray、copyToArray
   */
  private def func11: Unit = {
    val arr = abcde.toArray
    println(s"arr = ${arr.mkString("Array(", ", ", ")")}")
    println(s"arr.toList = ${arr.toList}")
    println()

    val arr2 = new Array[Int](10)
    println(s"arr2 = ${arr2.mkString("Array(", ", ", ")")}")
    List(1, 2, 3) copyToArray(arr2, 3)
    println(s"arr2 = ${arr2.mkString("Array(", ", ", ")")}")
    println()

    val it = abcde.iterator
    println(s"it.next() = ${it.next()}")
    println(s"it.next() = ${it.next()}")
    println()
  }

  /**
   * 显示列表：toString 和 mkString
   */
  private def func10: Unit = {
    println(s"abcde.toString() = ${abcde.toString()}")
    println(abcde mkString("[", ",", "]"))
    println(abcde mkString (""))
    println(abcde mkString "")
    println(s"abcde.mkString = ${abcde.mkString}")
    println(abcde mkString("List(", ", ", ")"))
    println()

    val buf = new StringBuilder
    println(abcde addString(buf, "(", ";", ")"))
    println()
  }

  /**
   * 将列表连起来：zip 和 unzip
   */
  private def func9: Unit = {
    println(s"abcde.indices zip abcde = ${abcde.indices zip abcde}")
    println(s"abcde.zipWithIndex = ${abcde.zipWithIndex}")
    println()

    val zipped: List[(Char, Int)] = abcde zip List(1, 2, 3)
    println(s"abcde zip List(1, 2, 3) = $zipped")
    println(s"zipped.unzip = ${zipped.unzip}")
    println()
  }

  /**
   * 扁平化列表的列表：flatten
   */
  private def func8: Unit = {
    println(s"List(List(1, 2), List(3), List(), List(4, 5)).flatten = ${List(List(1, 2), List(3), List(), List(4, 5)).flatten}")
    //noinspection MapFlatten
    println(s"fruit.map(_.toCharArray).flatten = ${fruit.map(_.toCharArray).flatten}")
    println(s"fruit.flatMap(_.toCharArray) = ${fruit.flatMap(_.toCharArray)}")
    println()

    // 这个方法只能应用于那些所有元素都是列表的列表
    //println(s"List(1, 2, 3).flatten = ${List(1, 2, 3).flatten}")
  }

  /**
   * 元素选择：apply 和 indices
   */
  private def func7: Unit = {
    println(s"abcde apply 2 = ${abcde apply 2}")
    println(s"abcde(2) = ${abcde(2)}")
    println(s"abcde.apply(2) == abcde(2) = ${abcde.apply(2) == abcde(2)}")
    println(s"abcde.apply(2) == (abcde drop 2).head = ${abcde.apply(2) == (abcde drop 2).head}")
    println()

    println(s"abcde.indices = ${abcde.indices}")
    for (index <- abcde.indices)
      println(s"index = ${index}, and value = ${abcde(index)}")

    println()
  }

  /**
   * 前缀和后缀：drop、take 和 splitAt
   * drop 和 take 是对 tail 和 last 的一般化
   * splitAt 操作将列表从指定位置的下标位置切开，返回这两个列表组成的对偶，对偶是 Tuple2 的非正式名称
   * splitAt 会避免遍历列表两次
   */
  private def func6: Unit = {
    println(s"abcde take 2 = ${abcde take 2}")
    println(s"abcde drop 2 = ${abcde drop 2}")
    println(s"abcde splitAt 2 = ${abcde splitAt 2}")
    println()
  }

  /**
   * 反转列表: reverse
   */
  private def func5: Unit = {
    println(s"abcde = ${abcde}")
    println(s"abcde.reverse = ${abcde.reverse}")
    println(s"abcde = ${abcde}")
    println(s"abcde.reverse.reverse = ${abcde.reverse.reverse}")
    println(s"abcde.reverse.init == abcde.tail.reverse = ${abcde.reverse.init == abcde.tail.reverse}")
    println(s"abcde.reverse.tail == abcde.init.reverse = ${abcde.reverse.tail == abcde.init.reverse}")
    println(s"abcde.reverse.head == abcde.last = ${abcde.reverse.head == abcde.last}")
    println(s"abcde.reverse.last == abcde.head = ${abcde.reverse.last == abcde.head}")
    println()

    println(s"rev(abcde) = ${rev(abcde)}")
    println()
  }

  /**
   * 反转操作用拼接 ::: 来事先，时间复杂度为 (n+1)*n/2, 效率很低
   */
  def rev[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case x :: xs1 => rev(xs1) ::: List(x)
  }

  /**
   * 访问列表的末端： init 和 last
   * head 和 tail 的对偶方法 last 和 init
   * 前两者算法复杂度 O(1), 后两者算法复杂度 O(n)
   * 所以最好将数据组织成大多数访问都发生在列表头部而不是尾部
   */
  private def func4: Unit = {
    println(s"abcde.last = ${abcde.last}")
    println(s"abcde.init = ${abcde.init}")
    println()
  }

  /**
   * 获取列表的长度 length
   */
  private def func3: Unit = {
    println(s"List(1, 2, 3).length = ${List(1, 2, 3).length}")
    println()
  }

  private def func2: Unit = {
    println(s"append(List(1, 2), List(3, 4)) = ${append(List(1, 2), List(3, 4))}")
    println()
  }

  /**
   * 拼接两个列表
   */
  private def func1: Unit = {
    println(s"List(1, 2) ::: List(3, 4, 5) = ${List(1, 2) ::: List(3, 4, 5)}")
    println(s"List() ::: List(1, 2, 3) = ${List() ::: List(1, 2, 3)}")
    println(s"List(1, 2, 3) ::: List(4) = ${List(1, 2, 3) ::: List(4)}")
    println()
  }

  /**
   * 分治原则
   * Divide and Conquer
   */
  def append[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case x :: xs1 => x :: append(xs1, ys)
  }

}
