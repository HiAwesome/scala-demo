package com.moqi.scala.ch35

import swing._

/**
 * 可视化框架
 *
 * @author moqi On 11/30/20 19:25
 */
object A01TheVisualFramework extends SimpleSwingApplication {

  override def top: Frame = new MainFrame {
    title = "ScalaSheet"
    contents = new Spreadsheet(100, 26)
  }

}

/**
 * 试算表中的代码
 */
class Spreadsheet(val height: Int, val width: Int) extends ScrollPane {

  val table = new Table(height, width) {
    rowHeight = 25
    autoResizeMode = Table.AutoResizeMode.Off
    showGrid = true
    gridColor = new java.awt.Color(150, 150, 150)
  }

  val rowHeader =
    new ListView((0 until height) map (_.toString)) {
      fixedCellWidth = 30
      fixedCellHeight = table.rowHeight
    }

  viewportView = table
  rowHeaderView = rowHeader
}