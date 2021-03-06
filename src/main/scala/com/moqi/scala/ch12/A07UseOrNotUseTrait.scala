package com.moqi.scala.ch12

/**
 * 要特质还是不要特质？
 *
 * 如果某个行为不会被复用，用具体的类；
 * 如果某个行为可能被用于多个互不相关的类，用特质；
 * 如果想要从 Java 代码中继承某个行为，用抽象类；
 * 如果计划将某个行为以编译好的形式分发，且预期会有外部的组织编写继承自它的类，可能会倾向于使用抽象类；
 * 如果外部的使用方只是调用到了这个行为而不是继承，那么使用特质也是可以的；
 * 如果你考虑了上述所有问题之后，仍然没有答案，那么就用特质。
 *
 * @author moqi On 11/6/20 16:55
 */
object A07UseOrNotUseTrait {

}
