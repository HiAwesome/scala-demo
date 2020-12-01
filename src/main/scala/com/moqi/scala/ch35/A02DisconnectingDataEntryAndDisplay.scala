package com.moqi.scala.ch35

import swing._
import event._

/**
 * 将数据录入与显示分开
 *
 * @author moqi On 12/1/20 09:25
 */
object A02DisconnectingDataEntryAndDisplay extends SimpleSwingApplication {

  override def top: Frame = new MainFrame {
    title = "ScalaSheet"
    contents = new Spreadsheet2(100, 26)
  }

}

/**
 * 带有 rendererComponent 方法的试算表
 */
class Spreadsheet2(val height: Int, val width: Int)
  extends ScrollPane {


  val cellModel = new Model(height, width)

  import cellModel._

  val table = new Table(height, width) {

    rowHeight = 25
    autoResizeMode = Table.AutoResizeMode.Off
    showGrid = true
    gridColor = new java.awt.Color(150, 150, 150)

    override def rendererComponent(isSelected: Boolean,
                                   hasFocus: Boolean, row: Int, column: Int): Component =

      if (hasFocus) new TextField(userData(row, column))
      else
        new Label(cells(row)(column).toString) {
          xAlignment = Alignment.Right
        }

    def userData(row: Int, column: Int): String = {
      val v = this (row, column)
      if (v == null) "" else v.toString
    }

    /**
     * 可以解析公式的试算表
     */
    reactions += {
      case TableUpdated(_, rows, column) =>
        for (row <- rows)
          cells(row)(column).formula =
            FormulaParsers.parse(userData(row, column))
    }
  }

  val rowHeader =
    new ListView((0 until height) map (_.toString)) {
      fixedCellWidth = 30
      fixedCellHeight = table.rowHeight
    }

  viewportView = table
  rowHeaderView = rowHeader
}

class Model(height: Int, width: Int) extends Evaluator with Arithmetic {

  case class Cell(row: Int, column: Int) {
    var formula: Formula = Empty

    def value = evaluate(formula)

    override def toString: String = formula match {
      case Textual(s) => s
      case _ => value.toString
    }
  }

  val cells = Array.ofDim[Cell](height, width)

  for (i <- 0 until height; j <- 0 until width)
    cells(i)(j) = Cell(i, j)
}