package com.moqi.scala.ch17

/**
 * 在可变和不可变集合类之间选择
 * 优先不可变
 *
 * @author moqi On 11/11/20 10:09
 */
object A03SelectingMutableOrNot {

  def main(args: Array[String]): Unit = {

    // Scala 提供了一个变通的解读：只要看到 a += b 而 a 并不支持名为 += 的方法，Scala 会尝试将它解读为 a = a + b
    val people = Set("Nancy", "Jane")
    //people += "bob"
    var peopleVar = Set("Nancy", "Jane")
    peopleVar += "bob"
    println(s"peopleVar = ${peopleVar}")
    peopleVar -= "Jane"
    println(s"peopleVar = ${peopleVar}")
    peopleVar ++= List("Tom", "Harry")
    println(s"peopleVar = ${peopleVar}")


  }

}
