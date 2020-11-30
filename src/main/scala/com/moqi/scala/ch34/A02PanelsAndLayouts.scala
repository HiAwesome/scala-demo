package com.moqi.scala.ch34

import scala.swing._

/**
 * 页面和布局
 *
 * @author moqi On 11/30/20 19:09
 */
object A02PanelsAndLayouts extends SimpleSwingApplication {

  def top: MainFrame = new MainFrame {
    title = "Second Swing App"

    val button = new Button {
      text = "Click me"
    }

    val label = new Label {
      text = "No button clicks registered"
    }

    contents = new BoxPanel(Orientation.Vertical) {
      contents += button
      contents += label
      border = Swing.EmptyBorder(30, 30, 10, 30)
    }
  }

}
