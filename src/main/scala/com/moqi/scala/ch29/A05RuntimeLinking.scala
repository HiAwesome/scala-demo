package com.moqi.scala.ch29

/**
 * 运行时链接
 *
 * @author moqi On 11/26/20 17:40
 */
object A05RuntimeLinking {

  def main(args: Array[String]): Unit = {


  }

}

/**
 * 动态选择模块实现的应用
 */
object GotApples {

  def main(args: Array[String]): Unit = {

    val db: Database =
      if (args(0) == "student")
        StudentDatabase
      else
        SimpleDatabase

    object browser extends Browser {

      /**
       * 单例类型
       */
      override val database: db.type = db
    }

    for (category <- db.allCategories)
      browser.displayCateGory(category)

    val apple = SimpleDatabase.foodNamed("Apple").get
    for (recipe <- browser.recipesUsing(apple)) println(s"recipe = ${recipe}")

  }

}