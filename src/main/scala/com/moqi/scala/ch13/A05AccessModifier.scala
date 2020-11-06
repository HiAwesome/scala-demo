package com.moqi.scala.ch13

/**
 * 访问修饰符
 *
 * @author moqi On 11/6/20 17:30
 */
object A05AccessModifier {

}

/**
 * 私有成员
 */
class Outer {

  class Inner {
    private def f() = println("f")

    class InnerMost {
      // It's OK
      f()
    }

  }

  // Java OK, Scala not OK
  // (new Inner).f()
}

/**
 * 受保护成员
 */
package p {

  class Super {
    protected def f() = println("f")
  }

  class Sub extends Super {
    f()
  }

  class Other {
    // Java OK, Scala not OK
    // (new Super).f()
  }

}

/**
 * 用访问限定符实现灵活的保护域
 */
package bobs {

  package navigation {

    private[bobs] class Navigator {
      protected[navigation] def useStarChart() = {}

      class LegOfJourney {
        private[navigation] val distance = 100
      }

      private[this] var speed = 200
    }

  }

  package launch {

    import navigation._

    object Vehicle {
      private[launch] val guide = new Navigator
    }

  }

}

/**
 * 伴生对象
 * 一个类会将它的所有访问权限与它的伴生对象共享，反过来也一样
 */
class Rocket {
  import Rocket.fuel
  private def canGoHomeAgain = fuel > 20
}

object Rocket {
  private def fuel = 10

  def chooseStrategy(rocket: Rocket) = {
    if (rocket.canGoHomeAgain)
      goHome()
    else
      pickAStart()
  }

  def goHome() = {}
  def pickAStart() = {}
}