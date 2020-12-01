package com.moqi.scala.ch35

import scala.swing.{Frame, MainFrame, SimpleSwingApplication}

/**
 * 变更通知
 *
 * @author moqi On 12/1/20 10:11
 */
object A07ChangePropagation extends SimpleSwingApplication {

  override def top: Frame = new MainFrame {
    title = "Final ScalaSheet"
    contents = new Spreadsheet2(100, 26)
  }

}