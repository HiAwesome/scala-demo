package com.moqi.scala.ch21

/**
 * 隐式参数
 * 在给隐式参数的类型命名时，至少使用一个能确定其职能的名字
 *
 * @author moqi On 11/20/20 11:14
 */
object JoesPrefs {
  implicit val prompt = new PreferredPrompt("Yes, master >")
}

object JoesPrefs2 {
  implicit val prompt2 = new PreferredPrompt("Yes, master >")
  implicit val drink = new PreferredDrink("tea")
}

object A05ImplicitParameters {

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

    func4

  }

  private def func4: Unit = {
    println(s"maxListImpParm(List(1, 5, 10, 3)) = ${maxListImpParm(List(1, 5, 10, 3))}")
    println(s"maxListImpParm(List(1.5, 2.3, 10.7, 3.1415926)) = ${maxListImpParm(List(1.5, 2.3, 10.7, 3.1415926))}")
    val res = maxListImpParm(List("one", "two", "three"))
    println(s"res = ${res}")
    println()
  }

  /**
   * 带有上界的函数
   */
  def maxListOrdering[T](elements: List[T])(implicit ordering: Ordering[T]): T = elements match {
    case List() => throw new IllegalArgumentException("empty list")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxListOrdering(rest)(ordering)
      if (ordering.gt(x, maxRest)) x else maxRest
  }

  /**
   * 将第二个参数设定为隐式的 -> 带有隐式参数的函数
   */
  def maxListImpParm[T](elements: List[T])(implicit ordering: Ordering[T]): T = elements match {
    case List() => throw new IllegalArgumentException("empty list")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxListOrdering(rest)(ordering)
      if (ordering.gt(x, maxRest)) x else maxRest
  }

  private def func3: Unit = {
    import JoesPrefs2._
    Greeter2.greet("Joe")(prompt2, drink)
    println()
  }

  private def func2: Unit = {
    import JoesPrefs._
    Greeter.greet("Joe")
    println()
  }

  private def func1: Unit = {
    val bobsPrompt = new PreferredPrompt("relax> ")
    Greeter.greet("Bob")(bobsPrompt)
    println()
  }
}

class PreferredPrompt(val preference: String)

class PreferredDrink(val preference: String)

object Greeter {

  def greet(name: String)(implicit prompt: PreferredPrompt) = {
    println("Welcome,  " + name + ". The system is ready.")
    println(prompt.preference)
  }

}

object Greeter2 {

  def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink) = {
    println("Welcome,  " + name + ". The system is ready.")
    print("But while you work, ")
    println("why not enjoy a cup of " + drink.preference + "?")
    println(prompt.preference)
  }

}
