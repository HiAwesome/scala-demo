package com.moqi.scala.ch13

/**
 * 包对象
 *
 * @author moqi On 11/6/20 17:47
 */
object A06PackageObject {

}

// 位于文件 bobs/package.scala 中
package object bobs {
  def showFruit(fruit: Fruit): Unit = {
    import fruit._
    println(name + "'s are " + color)
  }
}

// 位于文件 PrintMenu.scala 中
package printmenu {

  import bobs.Fruits
  import bobs.showFruit

  object PrintMenu {
    def main(args: Array[String]): Unit = {

      for (fruit <- Fruits.menu)
        showFruit(fruit)

    }
  }

}


