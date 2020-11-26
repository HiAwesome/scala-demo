package com.moqi.scala.ch28

/**
 * XML 字面量
 *
 * @author moqi On 11/26/20 11:17
 */
object A03XMLLiterals {

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

  }

  private def func3: Unit = {
    val x1 = <a>
      {3 + 4}
    </a>
    println(s"x1 = ${x1}")
    println()

    val x2 = <a>
      {"</a>potential security hole<a>"}
    </a>
    println(s"x2 = ${x2}")
    println()
  }

  private def func2: Unit = {
    val x1 = <a>
      {"Hello" + ", world"}
    </a>
    val yearMade = 1955
    val x2 = <a>
      {if (yearMade < 2000) <old>
        {yearMade}
      </old> else xml.NodeSeq.Empty}
    </a>
    println(s"x1 = ${x1}")
    println(s"x2 = ${x2}")
    println()
  }

  private def func1: Unit = {
    val x1 = <a>This is some XML. Here is a tag:
      <atag/>
    </a>
    println(s"x1 = ${x1}")
    println()
  }
}
