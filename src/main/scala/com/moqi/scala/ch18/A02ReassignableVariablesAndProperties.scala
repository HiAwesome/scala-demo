package com.moqi.scala.ch18

/**
 * 可被重新赋值的变量和属性
 *
 * @author moqi On 11/11/20 11:33
 */
object A02ReassignableVariablesAndProperties {

  def main(args: Array[String]): Unit = {

    val t = new Thermometer
    println(s"t = ${t}")
    t.celsius = 100
    println(s"t = ${t}")
    t.fahrenheit = -40
    println(s"t = ${t}")
    println()

  }

}

/**
 * 带有公有 var 的类
 */
class Time1 {
  var hour = 12
  var minute = 0
}

/**
 * 公有 var 是如何被展开成 getter 和 setter 方法的
 */
class Time2 {
  private[this] var h = 12
  private[this] var m = 0

  def hour: Int = h

  def hour_=(x: Int) = {
    h = x
  }

  def minute: Int = m

  def minute_=(x: Int) = {
    m = x
  }
}

/**
 * 直接定义 getter 和 setter 方法
 * 加入了自定义的校验逻辑
 */
class Time3 {
  private[this] var h = 12
  private[this] var m = 0

  def hour: Int = h

  def hour_=(x: Int) = {
    require(0 <= x && x < 24)
    h = x
  }

  def minute: Int = m

  def minute_=(x: Int) = {
    require(0 <= x && x < 60)
    m = x
  }
}

/**
 * 定义没有关联字段的 getter 和 setter 方法
 */
class Thermometer {
  var celsius: Float = _

  def fahrenheit = celsius * 9 / 5 + 32

  def fahrenheit_=(f: Float) = {
    celsius = (f - 32) * 5 / 9
  }

  override def toString: String = fahrenheit + "F/" + celsius + "C"
}
