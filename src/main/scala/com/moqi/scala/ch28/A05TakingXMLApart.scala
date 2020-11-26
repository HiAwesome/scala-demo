package com.moqi.scala.ch28

/**
 * 拆解 XML
 *
 * @author moqi On 11/26/20 11:54
 */
object A05TakingXMLApart {

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

  }

  private def func3: Unit = {
    val joe = <employee name="Joe" rank="code monkey" serial="123"/>
    println(joe \ "@name")
    println(joe \ "@serial")
    println()
  }

  private def func2: Unit = {
    val x2 = <a>
      <b>
        <c>hello</c>
      </b>
    </a>
    // 提取子元素
    val x2Sub = x2 \ "b"
    println(s"x2Sub = ${x2Sub}")
    println()

    println(x2 \ "c")
    println(x2 \\ "c")
    println(x2 \ "a")
    println(x2 \\ "a")
    println()
  }

  private def func1: Unit = {
    val x1 = <a>Sounds
      <tag/>
      good</a>
    // 提取文本
    println(s"x1.text = ${x1.text}")
    println()
  }
}
