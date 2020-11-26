package com.moqi.scala.ch28

/**
 * 反序列化
 *
 * @author moqi On 11/26/20 12:02
 */
object A06Deserialization {

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
    println(s"node = ${node}")
    val c1 = fromXML(node)
    println(s"c1 = ${c1}")
    println()

  }

  def fromXML(node: scala.xml.Node): CCTherm =
    new CCTherm {
      val description   = (node \ "description").text
      val yearMade      = (node \ "yearMade").text.toInt
      val dateObtained  = (node \ "dateObtained").text
      val bookPrice     = (node \ "bookPrice").text.toInt
      val purchasePrice = (node \ "purchasePrice").text.toInt
      val condition     = (node \ "condition").text.toInt
    }


}
