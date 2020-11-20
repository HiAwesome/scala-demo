/**
 * ~/Code/scala-demo/script/ch21(main ✗) scalac -Xprint:typer Mocha.scala
 * [[syntax trees at end of                     typer]] // Mocha.scala
 * package <empty> {
 *   object Mocha extends AnyRef with App {
 *     def <init>(): Mocha.type = {
 *       Mocha.super.<init>();
 *       ()
 *     };
 *     class PreferredDrink extends scala.AnyRef {
 *       <paramaccessor> private[this] val preference: String = _;
 *       <stable> <accessor> <paramaccessor> def preference: String = PreferredDrink.this.preference;
 *       def <init>(preference: String): Mocha.PreferredDrink = {
 *         PreferredDrink.super.<init>();
 *         ()
 *       }
 *     };
 *     private[this] val pref: Mocha.PreferredDrink = new Mocha.this.PreferredDrink("mocha");
 *     implicit <stable> <accessor> def pref: Mocha.PreferredDrink = Mocha.this.pref;
 *     def enjoy(name: String)(implicit drink: Mocha.PreferredDrink): Unit = {
 *       scala.Predef.println("Welcome, ".+(name));
 *       scala.Predef.print(". Enjoy a ");
 *       scala.Predef.print(drink.preference);
 *       scala.Predef.println("!")
 *     };
 *     Mocha.this.enjoy("reader")(Mocha.this.pref)
 *   }
 * }
 *
 * 使用隐式转换的代码示例
 * 类型检查后添加了隐式值的代码示例
 */
object Mocha extends App {

  class PreferredDrink(val preference: String)

  implicit val pref = new PreferredDrink("mocha")

  def enjoy(name: String)(implicit drink: PreferredDrink) = {
    println("Welcome, " + name)
    print(". Enjoy a ")
    print(drink.preference)
    println("!")
  }

  enjoy(("reader"))

}