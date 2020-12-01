package com.moqi.scala.ch35

import scala.swing.{Frame, MainFrame, SimpleSwingApplication}
import scala.util.parsing.combinator._

/**
 * 解析公式
 *
 * @author moqi On 12/1/20 09:49
 */
object A04ParsingFormulas extends SimpleSwingApplication {

  override def top: Frame = new MainFrame {
    title = "ScalaSheet"
    contents = new Spreadsheet2(100, 26)
  }

}

object FormulaParsers extends RegexParsers {
  def ident: Parser[String] = """[a-zA-Z_]\w*""".r

  def decimal: Parser[String] = """-?\d+(\.\d*)?""".r

  def cell: Parser[Coord] =
    """[A-Za-z]\d+""".r ^^ { s =>
      val column = s.charAt(0).toUpper - 'A'
      val row = s.substring(1).toInt
      Coord(row, column)
    }

  def range: Parser[Range] =
    cell ~ ":" ~ cell ^^ {
      case c1 ~ ":" ~ c2 => Range(c1, c2)
    }

  def number: Parser[Number] =
    decimal ^^ (d => Number(d.toDouble))

  def application: Parser[Application] =
    ident ~ "(" ~ repsep(expr, ",") ~ ")" ^^ {
      case f ~ "(" ~ ps ~ ")" => Application(f, ps)
    }

  def expr: Parser[Formula] =
    range | cell | number | application

  def textual: Parser[Textual] =
    """[^=].*""".r ^^ Textual

  def formula: Parser[Formula] =
    number | textual | "=" ~> expr

  def parse(input: String): Formula =
    parseAll(formula, input) match {
      case Success(e, _) => e
      case f: NoSuccess => Textual("[" + f.msg + "]")
    }
}