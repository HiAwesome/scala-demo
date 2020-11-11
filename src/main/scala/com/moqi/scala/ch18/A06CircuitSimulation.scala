package com.moqi.scala.ch18


/**
 * 电路模拟
 *
 * @author moqi On 11/11/20 14:44
 */
object MySimulation extends CircuitSimulation {

  override def InverterDelay: Int = 1

  override def AndGateDelay: Int = 3

  override def OrGateDelay: Int = 5

}

/**
 * BasicCircuitSimulation 类
 */
abstract class BasicCircuitSimulation extends Simulation {

  /**
   * 这些方法的名称以大写字母开头，因为表示常量。
   * 被定义为方法，因此可以被子类重写。
   */
  def InverterDelay: Int

  def AndGateDelay: Int

  def OrGateDelay: Int

  class Wire {
    private var sigVal = false

    private var actions: List[Action] = List()

    /**
     * 返回当前线的信号
     */
    def getSignal = sigVal

    /**
     * 将线的信号设置为 sig
     * 函数 _ () 是 f => f() 的简写，它接收一个函数（被称为 f）并将它应用到空的参数列表
     */
    def setSignal(s: Boolean) =
      if (s != sigVal) {
        sigVal = s
        actions foreach (_ ())
      }

    /**
     * 将给定的过程 p 附加在线的 actions 中
     */
    def addAction(a: Action) = {
      actions = a :: actions
      a()

    }
  }

  /**
   * 反转器
   */
  def inverter(input: Wire, output: Wire) = {
    def invertAction() = {
      val inputSig = input.getSignal
      afterDelay(InverterDelay) {
        output setSignal !inputSig
      }
    }

    input addAction invertAction
  }

  /**
   * 与门
   */
  def andGate(a1: Wire, a2: Wire, output: Wire) = {
    def andAction() = {
      val a1Sig = a1.getSignal
      val a2Sig = a2.getSignal
      afterDelay(AndGateDelay) {
        output setSignal (a1Sig & a2Sig)
      }
    }

    a1 addAction andAction
    a2 addAction andAction
  }

  /**
   * 或门
   */
  def orGate(o1: Wire, o2: Wire, output: Wire) = {
    def orAction() = {
      val o1Sig = o1.getSignal
      val o2Sig = o2.getSignal
      afterDelay(OrGateDelay) {
        output setSignal (o1Sig | o2Sig)
      }
    }

    o1 addAction orAction
    o2 addAction orAction
  }

  /**
   * 模拟赎出
   */
  def probe(name: String, wire: Wire) = {
    def probeAction() = {
      println(name + " " + currentTime + " new-value = " + wire.getSignal)
    }

    wire addAction probeAction
  }

}

/**
 * 包含半加器和全加器的模拟器
 */
abstract class CircuitSimulation extends BasicCircuitSimulation {

  def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire) = {
    val d, e = new Wire
    orGate(a, b, d)
    andGate(a, b, c)
    inverter(c, e)
    andGate(d, e, s)
  }

  def fullAdder(a: Wire, b: Wire, cin: Wire, sum: Wire, cout: Wire) = {
    val s, c1, c2 = new Wire
    halfAdder(a, cin, s, c1)
    halfAdder(b, s, sum, c2)
    orGate(c1, c2, cout)
  }

}