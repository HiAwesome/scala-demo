package com.moqi.scala.ch29

/**
 * 将模块拆分成特质
 *
 * @author moqi On 11/26/20 17:23
 */
object A04SplittingModulesIntoTraits {

  def main(args: Array[String]): Unit = {

    val apple = SimpleDatabase.foodNamed("Apple").get
    println(s"apple = ${apple}")
    println(s"SimpleBrowser.recipesUsing(apple) = ${SimpleBrowser.recipesUsing(apple)}")
    println()

  }

}

/**
 * 表示食物类目的特质
 */
trait FoodCategories {

  case class FoodCategory(name: String, foods: List[Food])

  def allCategories: List[FoodCategory]
}

trait SimpleFoods {

  object Pear extends Food("Pear")

  def allFoods = List(Apple, Pear)

  def allCategories = Nil
}

trait SimpleRecipes {
  /**
   * Scala 专门提供了自身类型 self type，制定了对于 trait 能够混入的具体类的要求
   */
  this: SimpleFoods =>

  object FruitSalad extends Recipe(
    "fruit salad",
    List(Apple, Pear),
    "Mix it all together."
  )

  def allRecipes = List(FruitSalad)
}