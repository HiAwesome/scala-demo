package com.moqi.scala.ch11

/**
 * 定义自己的值类型
 *
 * @author moqi On 11/5/20 16:36
 */
object A04UserDefineValueType {

  def main(args: Array[String]): Unit = {

    func1

    println(titleV0("chap:vcls", "bold", "Value Classes"))
    // 虽然都是字符串，但是自定义类型不符合，所以编译出错
    // println(title(new Anchor("chap:vcls"), new Style("bold"), new Text("Value Classes")))
    println(title(new Text("Value Classes"), new Anchor("chap:vcls"), new Style("bold")).value)

  }

  private def func1: Unit = {
    val money = new Dollars(100)
    println(s"money = ${money}")
    println(s"money.amount = ${money.amount}")
    println()

    val francs = new SwissFrancs(1000)
    println(s"francs = ${francs}")
    println()
  }

  def titleV0(text: String, anchor: String, style: String): String =
    s"<a id = '$anchor'><h1 class='$style'>$text</h1></a>"

  def title(text: Text, anchor: Anchor, style: Style): Html =
    new Html(
      s"<a id='${anchor.value}'>" +
        s"<h1 class='${style.value}'>" +
        text.value +
        "</h1></a>"
    )

}

class Dollars(val amount: Int) extends AnyVal {
  override def toString: String = "$" + amount
}

class SwissFrancs(val amount: Int) extends AnyVal {
  override def toString: String = amount + " CHF"
}

class Anchor(val value: String) extends AnyVal

class Style(val value: String) extends AnyVal

class Text(val value: String) extends AnyVal

class Html(val value: String) extends AnyVal