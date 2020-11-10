package com.moqi.scala.ch16

/**
 * 构建列表
 * :: 读作 cons，表示在列表前追加元素。
 * 也就是说 x :: xs，表示这样一个列表：第一个元素为 x，接下来是列表 xs 的全部元素
 *
 * @author moqi On 11/10/20 10:30
 */
object A03ConstructingLists {

  def main(args: Array[String]): Unit = {

    val fruit = "apples" :: ("orange" :: ("pears" :: Nil))
    val nums = 1 :: (2 :: (3 :: (4 :: Nil)))
    val diag3 =
      (1 :: (0 :: (0 :: Nil))) ::
        (0 :: (1 :: (0 :: Nil))) ::
        (0 :: (0 :: (1 :: Nil))) :: Nil
    val empty = Nil

    println(s"fruit = ${fruit}")
    println(s"nums = ${nums}")
    println(s"diag3 = ${diag3}")
    println(s"empty = ${empty}")
    println()

    // :: 符号是右结合的
    val nums2 = 1 :: 2 :: 3 :: 4 :: Nil
    println(s"nums = ${nums}")
    println(s"nums == nums2 = ${nums == nums2}")

  }

}
