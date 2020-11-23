package com.moqi.scala.ch23

/**
 * 用 for 推导式进行查询
 *
 * @author moqi On 11/23/20 10:25
 */
object A03QueryingWithForExpressions {

  val books: List[Book] =
    List(
      Book(
        "Structure and Interpretation of Computer Programs",
        "Abelson, Harold", "Sussman, Gerald J."
      ),
      Book(
        "Principles of Compiler Design",
        "Aho, Alfred", "Ullman, Jeffrey"
      ),
      Book(
        "Programming in Modula-2",
        "Wirth, Niklaus"
      ),
      Book(
        "Elements of ML Programming",
        "Ullman, Jeffrey"
      ),
      Book(
        "The Java Language Specification", "Gosling, James",
        "Joy, Bill", "Steele, Guy", "Bracha, Gilad"
      )
    )

  def main(args: Array[String]): Unit = {

    val authorsStartWithGoslingBookTitle = for (b <- books; a <- b.authors if a startsWith "Gosling") yield b.title
    println(s"authorsStartWithGoslingBookTitle = ${authorsStartWithGoslingBookTitle}")
    println()

    val titleContainsProgram = for (b <- books if (b.title indexOf "Program") >= 0) yield b.title
    println(s"titleContainsProgram = ${titleContainsProgram}")
    println()

    // 所有至少编写了数据库中两本书以上的作者的名字
    val author1 = for (b1 <- books; b2 <- books if b1 != b2; a1 <- b1.authors; a2 <- b2.authors if a1 == a2) yield a1
    println(s"author1 = ${author1}")
    println()

    val author2 = removeDuplicates(author1)
    println(s"author2 = ${author2}")
    println()

  }

  /**
   * 移除 List 中的重复项
   */
  def removeDuplicates[A](xs: List[A]): List[A] = {
    if (xs.isEmpty) xs
    else
      xs.head :: removeDuplicates(
        // xs.tail filter (x => x != xs.head)
        for (x <- xs.tail if x != xs.head) yield x
      )
  }

}

case class Book(title: String, authors: String*)
