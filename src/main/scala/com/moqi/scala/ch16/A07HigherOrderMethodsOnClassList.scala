package com.moqi.scala.ch16

/**
 * List 类的高阶方法
 * 如果一个函数接收一个或多个函数作为参数，那么它就是高阶的
 *
 * @author moqi On 11/10/20 14:33
 */
object A07HigherOrderMethodsOnClassList {

  private val words = List("the", "quick", "brown", "fox")
  private val nums = List(1, 2, 3, 4, 5)
  private val diag3 =
    List(
      List(1, 0, 0),
      List(0, 1, 0),
      List(0, 0, 1)
    )

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

    func4

    func5

  }

  /**
   * 列表排序: sortWith
   */
  private def func5: Unit = {
    println(s"List(1, -3, 4, 2, 6) sortWith (_ < _) = ${List(1, -3, 4, 2, 6) sortWith (_ < _)}")
    println(s"List(1, -3, 4, 2, 6) sortWith (_ > _) = ${List(1, -3, 4, 2, 6) sortWith (_ > _)}")
    println(s"words sortWith (_.length > _.length) = ${words sortWith (_.length > _.length)}")
    println()
  }

  /**
   * 折叠列表 foldLeft 和 foldRight
   * 左折叠和右折叠
   * List(a, b, c).foldLeft(z)(op) 等于 op(op(op(z, a), b), c)
   * List(a, b, c).foldRight(z)(op) 等于 op(a, op(b, op(c, z)))
   */
  private def func4: Unit = {
    //noinspection SimplifiableFoldOrReduce
    def sum(xs: List[Int]): Int = xs.foldLeft(0)(_ + _)

    println(s"sum(nums) = ${sum(nums)}")
    println(s"sum(nums) == nums.sum = ${sum(nums) == nums.sum}")
    println()

    //noinspection SimplifiableFoldOrReduce
    def product(xs: List[Int]): Int = xs.foldLeft(1)(_ * _)

    println(s"product(nums) = ${product(nums)}")
    println(s"product(nums) == nums.product = ${product(nums) == nums.product}")
    println()

    // 拼接字符串
    println(words.foldLeft("")(_ + " " + _))
    // 拼接字符串，去掉最开头的空格
    println(words.tail.foldLeft(words.head)(_ + " " + _))
    println()

    /**
     * 对结合性的操作而言，左折叠和右折叠是等效的，不过可能存在执行效率上的差异
     * 列表拼接右折叠比左折叠更加高效
     * 两个折叠都需要对折叠起始值的空列表做类型注解，这是因为 Scala 类型推断程序的一个局限
     * 不能自动推断出正确的列表类型
     */
    def flattenLeft[T](xss: List[List[T]]) = xss.foldLeft(List[T]())(_ ::: _)

    def flattenRight[T](xss: List[List[T]]) = xss.foldRight(List[T]())(_ ::: _)

    println(s"flattenLeft(List(List(1, 2), List(3, 4))) = ${flattenLeft(List(List(1, 2), List(3, 4)))}")
    println(s"flattenRight(List(List(1, 2), List(3, 4))) = ${flattenRight(List(List(1, 2), List(3, 4)))}")
    println()

    /**
     * 例子：用 fold 反转列表
     */
    def reverseLeft[T](xs: List[T]): List[T] =
      xs.foldLeft(List[T]()) { (ys, y) => y :: ys }

    println(s"reverseLeft(nums) = ${reverseLeft(nums)}")
    println()
  }

  /**
   * 对列表的前提条件检查： forall 和 exists
   * forall 表示列表中所有元素都满足 p
   * exists 表示列表中存在至少一个元素满足 p
   */
  private def func3: Unit = {
    // 判断矩阵里是否存在一行元素全部为 0
    def hasZeroRow(m: List[List[Int]]): Boolean =
      m exists (row => row forall (_ == 0))

    println(s"hasZeroRow(diag3) = ${hasZeroRow(diag3)}")
    println()
  }

  /**
   * 过滤列表：filter、partition、find、takeWhile、dropWhile、span
   */
  private def func2: Unit = {
    println(s"nums filter (_ % 2 == 0) = ${nums filter (_ % 2 == 0)}")
    println(s"words filter (_.length == 3) = ${words filter (_.length == 3)}")
    println()

    println(s"nums partition (_ % 2 == 0) = ${nums partition (_ % 2 == 0)}")
    println()

    println(s"nums find (_ % 2 == 0) = ${nums find (_ % 2 == 0)}")
    println(s"nums find (_ <= 0) = ${nums find (_ <= 0)}")
    println()

    // xs takeWhile p 操作返回列表 xs 中连续满足 p 的最长前缀
    // xs dropWhile p 操作将去除列表 xs 中连续满足 p 的最长前缀
    println(s"List(1, 2, 3, -4, 5) takeWhile (_ > 0) = ${List(1, 2, 3, -4, 5) takeWhile (_ > 0)}")
    println(s"words dropWhile (_ startsWith t) = ${words dropWhile (_ startsWith "t")}")
    println()

    // span 将 takeWhile 和 dropWhile 合二为一，就像 splitAt 将 take 和 drop 合二为一一样
    println(s"List(1, 2, 3, -4, 5) span (_ > 0) = ${List(1, 2, 3, -4, 5) span (_ > 0)}")
    println()
  }

  /**
   * 对列表做映射：map、flatMap 和 foreach
   */
  private def func1: Unit = {
    println(s"List(1, 2, 3) map (_ + 1) = ${List(1, 2, 3) map (_ + 1)}")
    println(s"words map (_.length) = ${words map (_.length)}")
    println(s"words map (_.toList.reverse.mkString) = ${words map (_.toList.reverse.mkString)}")
    println()

    println(s"words map (_.toList) = ${words map (_.toList)}")
    println(s"words flatMap (_.toList) = ${words flatMap (_.toList)}")
    println()

    // 构建一个满足 1 <= j < i < 5 的所有对偶 (i, j)
    val tuple2 = List.range(1, 5) flatMap (i => List.range(1, i) map (j => (i, j)))
    println(s"tuple2 = ${tuple2}")
    val forTuple2 = for (i <- List.range(1, 5); j <- List.range(1, i)) yield (i, j)
    println(s"forTuple2 = ${forTuple2}")
    println()

    var sum = 0
    nums foreach (sum += _)
    println(s"sum = ${sum}")
    println()
  }
}
