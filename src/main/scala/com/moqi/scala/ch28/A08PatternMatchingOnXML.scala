package com.moqi.scala.ch28

/**
 * 对 XML 做模式匹配
 * 不要格式化这个文件，参考：https://youtrack.jetbrains.com/issue/SCL-18500
 *
 * @author moqi On 11/26/20 14:27 */
object A08PatternMatchingOnXML {

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

    func4
  }

  private def func4: Unit = {
    val catalog = <catalog>
      <cctherm>
        <description>hot dog #5</description> <yearMade>1952</yearMade> <dateObtained>March 14, 2006</dateObtained> <bookPrice>2199</bookPrice> <purchasePrice>500</purchasePrice> <condition>9</condition>
      </cctherm> <cctherm>
        <description>Sprite Boy</description> <yearMade>1964</yearMade> <dateObtained>April 28, 2003</dateObtained> <bookPrice>1695</bookPrice> <purchasePrice>595</purchasePrice> <condition>5</condition>
      </cctherm>
    </catalog>

    catalog match {
      case <catalog>{therms@_*}</catalog> =>
        for (therm <- therms)
          println("processing: " + (therm \ "description").text)
    }
    println()

    catalog match {
      case <catalog>{therms@_*}</catalog> =>
        for (therm @ <cctherm>{_*}</cctherm>  <-  therms)
          println("processing: " + (therm \ "description").text)
    }
    println()
  }

  private def func3: Unit = {
    val v1 = proc2(<a>a <em>red</em> apple</a>)
    println(s"v1 = ${v1}")
    val v2 = proc2(<a/>)
    println(s"v2 = ${v2}")
    println()
  }

  private def func2: Unit = {
    val v1 = proc(<a>a <em>red</em> apple</a>)
    println(s"v1 = ${v1}")
    val v2 = proc(<a/>)
    println(s"v2 = ${v2}")
    println()
  }

  private def func1: Unit = {
    val v1 = proc(<a>apple</a>)
    println(s"v1 = ${v1}")
    val v2 = proc(<b>banana</b>)
    println(s"v2 = ${v2}")
    val v3 = proc(<c>cherry</c>)
    println(s"v3 = ${v3}")
    println()
  }

  def proc2(node: scala.xml.Node): String = node match {
    case <a>{contents@_*}</a> => "It's an a: " + contents
    case <b>{contents@_*}</b> => "It's an b: " + contents
    case _ => "It's something else."
  }

  def proc(node: scala.xml.Node): String = node match {
    case <a>{contents}</a> => "It's an a: " + contents
    case <b>{contents}</b> => "It's an b: " + contents
    case _ => "It's something else."
  }

}
