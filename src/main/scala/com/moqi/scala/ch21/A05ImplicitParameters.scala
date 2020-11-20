package com.moqi.scala.ch21

/**
 * 隐式参数
 *
 * @author moqi On 11/20/20 11:14
 */
object JoesPrefs {
  implicit val prompt = new PreferredPrompt("Yes, master >")
}

object A05ImplicitParameters {

  def main(args: Array[String]): Unit = {

    val bobsPrompt = new PreferredPrompt("relax> ")
    Greeter.greet("Bob")(bobsPrompt)
    println()

    import JoesPrefs._
    Greeter.greet("Joe")
    println()

  }

}

class PreferredPrompt(val preference: String)

object Greeter {

  def greet(name: String)(implicit prompt: PreferredPrompt) = {
    println("Welcome,  " + name + ". The system is ready.")
    println(prompt.preference)
  }

}
