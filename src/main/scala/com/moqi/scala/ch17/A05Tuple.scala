package com.moqi.scala.ch17

/**
 * 元组
 * 元组可以帮我们省去定义那些简单的主要承载数据的类的麻烦
 *
 * @author moqi On 11/11/20 10:54
 */
object A05Tuple {

  def main(args: Array[String]): Unit = {

    val t1 = (1, "hello", Console)
    println(s"t1 = ${t1}")

    val longest = longestWord("The quick brown fox".split(" "))
    println(s"longest._1 = ${longest._1}, longest._2 =  ${longest._2}")
    // 带括号
    val (word, idx) = longest
    println(s"word = ${word}, idx = ${idx}")
    println()
    // 不带括号
    val word2, idx2 = longest
    println(s"word2 = ${word2}, idx2 = ${idx2}")
    println()

  }

  /**
   * 元组一个常见的应用场景是从方法返回多个值
   */
  def longestWord(words: Array[String]): (String, Int) = {
    var word = words(0)
    var idx = 0
    for (i <- 1 until words.length)
      if (words(i).length > word.length) {
        word = words(i)
        idx = i
      }

    (word, idx)
  }

}
