package com.moqi.scala.ch12

/**
 * 瘦借口和富借口
 *
 * @author moqi On 11/6/20 15:14
 */
object A02ThinInterfacesAndRichExcuses {

}

trait A02CharSequence {
  def charAt(index: Int): Char
  def length: Int
  def subSequence(start: Int, end: Int): CharSequence
  override def toString: String = "A02CharSequence"
}