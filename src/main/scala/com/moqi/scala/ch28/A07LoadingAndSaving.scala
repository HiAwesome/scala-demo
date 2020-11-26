package com.moqi.scala.ch28

/**
 * 加载与保存
 *
 * @author moqi On 11/26/20 14:21
 */
object A07LoadingAndSaving {

  def main(args: Array[String]): Unit = {

    val therm = new CCTherm {
      override val description: String = "hot dog #5"
      override val yearMade: Int = 1952
      override val dateObtained: String = "March 14, 2006"
      override val bookPrice: Int = 2199
      override val purchasePrice: Int = 500
      override val condition: Int = 9
    }

    val node = therm.toXML
    xml.XML.save("therm1.xml", node)
    println("output xml success")
    println()

    val loadNode = xml.XML.loadFile("therm1.xml")
    println(s"loadNode = ${loadNode}")
    println()

  }

}