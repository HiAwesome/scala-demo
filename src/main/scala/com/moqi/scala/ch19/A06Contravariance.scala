package com.moqi.scala.ch19

/**
 * 逆变
 *
 * @author moqi On 11/12/20 10:46
 */
object Customer extends App {
  def getTitle(p: Publication): String = p.title

  Library.printBookList(getTitle)
}

/**
 * 逆变的输出通道特质
 */
trait OutputChannel[-T] {
  def write(x: T)
}

/**
 * Function1 的协变和逆变
 */
trait Function1[-S, +T] {
  def apply(x: S): T
}

class Publication(val title: String)

class Book(title: String) extends Publication(title)

object Library {
  val books: Set[Book] =
    Set(new Book("Programming in Scala"),
      new Book("Walden"))

  /**
   * 函数参数型变的展示
   * 因为 Publication => String 是 Book => AnyRef 的子类型，而 Function1 定义为协变的
   */
  def printBookList(info: Book => AnyRef) = for (book <- books) println(info(book))

}
