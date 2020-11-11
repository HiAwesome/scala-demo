package com.moqi.scala.ch18

/**
 * The Simulation API
 *
 * @author moqi On 11/11/20 14:27
 */
object A05TheSimulationAPI {

}

/**
 * Simulation 类
 */
abstract class Simulation {
  type Action = () => Unit

  /**
   * 工作项
   */
  case class WorkItem(time: Int, action: Action)

  private var curtime = 0

  def currentTime: Int = curtime

  /**
   * 日程
   */
  private var agenda: List[WorkItem] = List()

  /**
   * 保证日程是按照事件排序的
   */
  private def insert(ag: List[WorkItem], item: WorkItem): List[WorkItem] = {
    if (ag.isEmpty || item.time < ag.head.time) item :: ag
    else ag.head :: insert(ag.tail, item)
  }

  /**
   * 向日程中添加工作项的唯一方式
   */
  def afterDelay(delay: Int)(block: => Unit) = {
    val item = WorkItem(currentTime + delay, () => block)
    agenda = insert(agenda, item)
  }

  /**
   * 将日程拆成一个最开始的工作项 item 和剩下的工作项 rest 两部分，然后将最开始的工作项移除
   * 将模拟事件 curtime 设定为工作项的时间，并执行该工作项的工作
   */
  private def next() = {
    // 使用 unchecked 注解压制 match is not exhaustive（匹配并不穷尽）的警告
    (agenda: @unchecked) match {
      case item :: rest =>
        agenda = rest
        curtime = item.time
        item.action()
    }
  }

  /**
   * 不断从日程中获取第一个工作项，从日程移除并执行
   * 注意 next 只能在日程不为空时调用，并没有给出空列表的 case，因此如果发生这种情况会直接抛出异常
   */
  def run() = {
    afterDelay(0) {
      println("*** simulation started, time = " + currentTime + " ***")
    }
    while (agenda.nonEmpty) next()
  }

}