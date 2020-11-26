package com.moqi.scala.ch29

/**
 * 抽象
 *
 * @author moqi On 11/26/20 17:03
 */
object A03Abstraction {

  def main(args: Array[String]): Unit = {

    val apple = SimpleDatabase.foodNamed("Apple").get
    println(s"apple = ${apple}")
    println(s"SimpleBrowser.recipesUsing(apple) = ${SimpleBrowser.recipesUsing(apple)}")
    println()

  }

}

abstract class Browser {
  val database: Database

  def recipesUsing(food: Food) =
    database.allRecipes.filter(recipe =>
      recipe.ingredients.contains(food))

  def displayCateGory(category: database.FoodCategory) = println(category)
}

abstract class Database extends FoodCategories {
  def allFoods: List[Food]

  def allRecipes: List[Recipe]

  def foodNamed(name: String) = allFoods.find(f => f.name == name)

}

/**
 * 学生数据库和浏览器
 */
object StudentDatabase extends Database {

  object FrozenFood extends Food("FrozenFood")

  object HeatItUp extends Recipe(
    "heat it up",
    List(FrozenFood),
    "Microwave the 'food' for 10 minutes."
  )

  override def allFoods: List[Food] = List(FrozenFood)

  override def allRecipes: List[Recipe] = List(HeatItUp)

  override def allCategories: List[StudentDatabase.FoodCategory] = List(
    FoodCategory("edible", List(FrozenFood))
  )
}

object StudentBrowser extends Browser {
  override val database: Database = StudentDatabase
}