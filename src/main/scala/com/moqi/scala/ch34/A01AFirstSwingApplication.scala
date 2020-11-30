package com.moqi.scala.ch34

import scala.swing._

/**
 * 第一个 Swing 程序
 *
 * @author moqi On 11/30/20 17:57
 */
object A01AFirstSwingApplication extends SimpleSwingApplication {

  def top: MainFrame = new MainFrame {
    title = "First Swing App"
    contents = new Button {
      text = "Click me"
    }
  }

}
