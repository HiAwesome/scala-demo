package com.moqi.scala.ch21

import java.awt.event.{ActionEvent, ActionListener}

import javax.swing.JButton

/**
 * 隐式转换
 *
 * @author moqi On 11/17/20 10:08
 */
object A01ImplicitConversions {

  def main(args: Array[String]): Unit = {


  }

  val button = new JButton
  button.addActionListener(
    new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = println("pressed!")
    }
  )

  /**
   * 隐式转换前类型不匹配，隐式转换后可以了
   */
  button.addActionListener(
    (_: ActionEvent) => println("pressed")
  )

  /**
   * 两个类型之间的隐式转换
   * 由于方法被标记为隐式的，可以不写出这个调用，编译器会自动插入
   */
  implicit def function2ActionListener(f: ActionEvent => Unit) =
    new ActionListener {
      override def actionPerformed(event: ActionEvent): Unit = f(event)
    }

  button.addActionListener(
    function2ActionListener(
      (_:ActionEvent) => println("pressed!")
    )
  )

}
