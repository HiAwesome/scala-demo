package com.moqi.scala.ch34

import scala.swing._
import scala.swing.event._

/**
 * 处理事件
 * 实现一个有响应的 Swing 应用程序
 *
 * @author moqi On 11/30/20 19:13
 */
object A03HandlingEvents extends SimpleSwingApplication {

  def top: MainFrame = new MainFrame {
    title = "Reactive Swing App"

    val button = new Button {
      text = "Click me"
    }

    val label = new Label {
      text = "No button clicks registered"
    }

    contents = new BoxPanel(Orientation.Vertical) {
      contents += button
      contents += label
      border = Swing.EmptyBorder(30, 30, 30, 30)
    }

    listenTo(button)

    var nClicks = 0

    reactions += {
      case ButtonClicked(b) =>
        nClicks += 1
        label.text = "Number of button clicks: " + nClicks
    }
  }

}
