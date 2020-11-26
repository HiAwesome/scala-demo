package com.moqi.scala.ch29

/**
 * 食谱应用程序
 *
 * @author moqi On 11/26/20 16:12
 */
object A02ARecipeApplication {

  def main(args: Array[String]): Unit = {

    func1


  }

  private def func1: Unit = {
    val apple = SimpleDatabase.foodNamed("Apple").get
    println(s"apple = ${apple}")
    println(s"SimpleBrowser.recipesUsing(apple) = ${SimpleBrowser.recipesUsing(apple)}")
    println()
  }
}

/**
 * 简单的 Food 实体类
 */
abstract class Food(val name: String) {
  override def toString: String = name
}

/**
 * 简单的 食谱 实体类
 */
class Recipe(val name: String,
             val ingredients: List[Food],
             val instructions: String) {
  override def toString: String = name
}

/**
 * 用于测试的 Food 和 Recipe 示例
 */
object Apple extends Food("Apple")

object Orange extends Food("Orange")

object Cream extends Food("Cream")

object Sugar extends Food("Sugar")

object FruitSalad extends Recipe(
  name = "fruit salad",
  List(Apple, Orange, Cream, Sugar),
  instructions = "Stir it all together."
)

/**
 * 模拟数据库和浏览器模块
 */
object SimpleDatabase {
  def allFoods = List(Apple, Orange, Cream, Sugar)

  def foodNamed(name: String): Option[Food] =
    allFoods.find(_.name == name)

  def allRecipes: List[Recipe] = List(FruitSalad)

  case class FoodCategory(name: String, foods: List[Food])

  private var categories = List(
    FoodCategory("fruits", List(Apple, Orange)),
    FoodCategory("misc", List(Cream, Sugar)))

  def allCategories = categories
}

object SimpleBrowser {
  def recipesUsing(food: Food) =
    SimpleDatabase.allRecipes.filter(recipe =>
      recipe.ingredients.contains(food))

  def displayCategory(category: SimpleDatabase.FoodCategory) = {
    println(category)
  }
}