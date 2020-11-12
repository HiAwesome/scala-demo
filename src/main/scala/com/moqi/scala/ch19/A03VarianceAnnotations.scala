package com.moqi.scala.ch19

/**
 * 型变注解
 *
 * @author moqi On 11/11/20 19:21
 */
object A03VarianceAnnotations {

  def main(args: Array[String]): Unit = {

    func1


    func2

    func3

  }

  /**
   * 用 Scala 复现 java.lang.ArrayStoreException: java.lang.Integer
   * Scala 允许将元素类型为 T 的数组类型转换成 T 的任意超类型的数组
   */
  private def func3: Unit = {
    val a1 = Array("abc")
    // 因为 Scala 默认是不变的，无法编译成功
    // val a2: Array[Any] = a1
    val a2: Array[Object] = a1.asInstanceOf[Array[Object]]
    a2(0) = new Integer(17)
    val s = a1(0)
  }

  /**
   * 测试 Scala 默认是不变的，以下代码并无法编译成功，会显示
   * type mismatch;
   *  found   : com.moqi.scala.ch19.Cell[String]
   *  required: com.moqi.scala.ch19.Cell[Any]
   * Note: String <: Any, but class Cell is invariant in type T.
   * You may wish to define T as +T instead. (SLS 4.5)
   *     val c2: Cell[Any] = c1
   */
  private def func2: Unit = {
    /*val c1 = new Cell[String]("abc")
    val c2: Cell[Any] = c1
    c1.set(1)
    val s: String = c1.get*/
  }

  private def func1: Unit = {
    val q1: A01Queue[Int] = A01Queue(1, 2, 3)
    // 无法编译，因为默认是不变的
    // doesCompileA01(q1)

    val q3: A03Queue[String] = new A03Queue[String]
    // 可以编译，因为是协变的
    doesCompileA03(q3)

    val q3V2: A03QueueV2[AnyRef] = new A03QueueV2[AnyRef]
    // 可以编译，因为是拟变的
    doesCompileA03V2(q3V2)
    println()
  }

  /**
   * 特质让我们可以指定参数化类型
   */
  def doesCompileA01(q: A01Queue[AnyRef]): Unit = {}

  /**
   * 指定为 String 的父类类型 AnyRef
   */
  def doesCompileA03(q: A03Queue[AnyRef]): Unit = {}

  /**
   * 指定为 AnyRef 的子类类型 String
   */
  def doesCompileA03V2(q: A03QueueV2[String]): Unit = {}

}

/**
 * 在 Scala 中，泛型类型默认的子类型规则是不变的 nonvariant, 或者说刻板的
 * 在类型形参前面加上 + 表示子类型关系在这个参数上是协变的 convariant，灵活的
 * 这样 Queue[String] 是 Queue[AnyRef] 的自类型
 */
class A03Queue[+T] {}

/**
 * - 表示逆变，如果 T 是 S 的子类型，则表示 Queue[S] 是 Queue[T] 的子类型
 */
class A03QueueV2[-T] {}

/**
 * 一个不变的（刻板的）Cell 类
 */
class Cell[T](init: T) {
  private[this] var current = init

  def get: T = current

  def set(x: T): Unit = {
    current = x
  }
}