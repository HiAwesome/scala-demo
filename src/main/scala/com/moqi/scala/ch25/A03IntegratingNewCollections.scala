package com.moqi.scala.ch25


import scala.collection.{
  AbstractIterator, mutable,
  SpecificIterableFactory, StrictOptimizedSeqOps
}
import scala.collection.immutable.{IndexedSeq, IndexedSeqOps}
import scala.collection._
import scala.language.implicitConversions

/**
 * 生成新的集合
 *
 * @author moqi On 11/25/20 11:51
 */
object A03IntegratingNewCollections {

  def main(args: Array[String]): Unit = {

    func1

    func2

    func3

    func4

  }

  private def func4: Unit = {
    val p1 = PrefixMap("hello" -> 5, "hi" -> 2)
    println(s"p1 = ${p1}")
    val p2 = PrefixMap.empty[String]
    println(s"p2 = ${p2}")
    val p3 = p1 map { case (k, v) => (k + "!", "x" * v) }
    println(s"p3 = ${p3}")
    println()
  }

  private def func3: Unit = {
    val m = PrefixMap("abc" -> 0, "abd" -> 1, "al" -> 2, "all" -> 3, "xyz" -> 4)
    println(s"m = ${m}")
    val ma = m withPrefix "a"
    println(s"ma = ${ma}")
    println()
  }

  private def func2: Unit = {
    val r2 = RNA(A, U, G, G, C)
    println(s"r2 = ${r2}")
    println(s"r2 map (base => base) = ${r2 map (base => base)}")
    println(s"r2 ++ r2 = ${r2 ++ r2}")
    println()

    val bases: Iterable[Base] = List(A, U, G, C)
    println(s"bases = ${bases}")
    val b2 = bases.to(RNA)
    println(s"b2 = ${b2}")
    println()
  }

  private def func1: Unit = {
    val r1 = RNA1.fromSeq(List(A, G, U, A))
    println(s"r1 = ${r1}")
    val r2 = RNA1(A, U, G, G, C)
    println(s"r2 = ${r2}")
    println(s"r1.take(3) = ${r1.take(3)}")
    println(s"r1.filter(_ != U) = ${r1.filter(_ != U)}")
    println(s"r1.map(base => base) = ${r1.map(base => base)}")
    println(s"r1 ++ r1 = ${r1 ++ r1}")
    println()
  }
}

abstract class Base

case object A extends Base

case object U extends Base

case object G extends Base

case object C extends Base

object Base {
  val fromInt: Int => Base = Array(A, U, G, C)
  val toInt: Base => Int = Map(A -> 0, U -> 1, G -> 2, C -> 3)
}


final class RNA1 private(val groups: Array[Int],
                         val length: Int) extends IndexedSeq[Base]
  with IndexedSeqOps[Base, IndexedSeq, RNA1] {

  import RNA1._

  def apply(idx: Int): Base = {
    if (idx < 0 || length <= idx) throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
  }

  override def className = "RNA1"

  override protected def fromSpecific(source: IterableOnce[Base]): RNA1 = fromSeq(source.iterator.toSeq)

  override protected def newSpecificBuilder: mutable.Builder[Base, RNA1] =
    iterableFactory.newBuilder[Base].mapResult(fromSeq)

  override def empty: RNA1 = fromSeq(Seq.empty)
}

object RNA1 {

  // Number of bits necessary to represent group
  private val S = 2
  // Number of groups that fit in an Int
  private val N = 32 / S
  // Bitmask to isolate a group
  private val M = (1 << S) - 1

  def fromSeq(buf: collection.Seq[Base]): RNA1 = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for (i <- buf.indices)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
    new RNA1(groups, buf.length)
  }

  def apply(bases: Base*) = fromSeq(bases)
}


final class RNA private(val groups: Array[Int],
                        val length: Int) extends IndexedSeq[Base]
  with IndexedSeqOps[Base, IndexedSeq, RNA]
  with StrictOptimizedSeqOps[Base, IndexedSeq, RNA] {
  rna =>

  import RNA._

  // Mandatory implementation of `apply` in `IndexedSeqOps`
  def apply(idx: Int): Base = {
    if (idx < 0 || length <= idx) throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
  }

  override def className = "RNA"

  override protected def fromSpecific(source: IterableOnce[Base]): RNA = RNA.fromSpecific(source)

  override protected def newSpecificBuilder: mutable.Builder[Base, RNA] =
    RNA.newBuilder

  override def empty: RNA = RNA.empty

  // Overload methods to return RNA
  def appended(base: Base): RNA =
    (newSpecificBuilder ++= this += base).result()

  def appendedAll(suffix: IterableOnce[Base]): RNA =
    strictOptimizedConcat(suffix, newSpecificBuilder)

  def concat(suffix: IterableOnce[Base]): RNA =
    strictOptimizedConcat(suffix, newSpecificBuilder)

  def flatMap(f: Base => IterableOnce[Base]): RNA =
    strictOptimizedFlatMap(newSpecificBuilder, f)

  def map(f: Base => Base): RNA =
    strictOptimizedMap(newSpecificBuilder, f)

  def prepended(base: Base): RNA =
    (newSpecificBuilder += base ++= this).result()

  def prependedAll(prefix: Iterable[Base]): RNA =
    (newSpecificBuilder ++= prefix ++= this).result()

  @inline def ++(suffix: IterableOnce[Base]): RNA =
    concat(suffix)

  // Optional re-implementation of iterator,
  // to make it more efficient.
  override def iterator: Iterator[Base] =
    new AbstractIterator[Base] {
      private var i = 0
      private var b = 0

      def hasNext: Boolean = i < rna.length

      def next(): Base = {
        b = if (i % N == 0) groups(i / N) else b >>> S
        i += 1
        Base.fromInt(b & M)
      }
    }
}

object RNA extends SpecificIterableFactory[Base, RNA] {

  private val S = 2 // number of bits in group
  private val M = (1 << S) - 1 // bitmask to isolate a group
  private val N = 32 / S // number of groups in an Int

  def fromSeq(buf: collection.Seq[Base]): RNA = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for (i <- buf.indices)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
    new RNA(groups, buf.length)
  }

  // Implement factory methods required by
  // SpecificIterableFactory
  def empty: RNA = fromSeq(Seq.empty)

  def newBuilder: mutable.Builder[Base, RNA] =
    mutable.ArrayBuffer.newBuilder[Base].mapResult(fromSeq)

  def fromSpecific(it: IterableOnce[Base]): RNA = it match {
    case seq: collection.Seq[Base] => fromSeq(seq)
    case _ => fromSeq(mutable.ArrayBuffer.from(it))
  }
}

class PrefixMap[A] extends mutable.Map[String, A]
  with mutable.MapOps[String, A, mutable.Map, PrefixMap[A]]
  with StrictOptimizedIterableOps
    [(String, A), mutable.Iterable, PrefixMap[A]] {

  private var suffixes: immutable.Map[Char, PrefixMap[A]] =
    immutable.Map.empty

  private var value: Option[A] = None

  def get(s: String): Option[A] =
    if (s.isEmpty) value
    else suffixes get (s(0)) flatMap (_.get(s substring 1))

  def addOne(kv: (String, A)): this.type = {
    withPrefix(kv._1).value = Some(kv._2)
    this
  }

  def subtractOne(s: String): this.type = {
    if (s.isEmpty) {
      val prev = value;
      value = None;
      prev
    }
    else suffixes get (s(0)) flatMap (_.remove(s substring 1))
    this
  }

  def withPrefix(s: String): PrefixMap[A] =
    if (s.isEmpty) this
    else {
      val leading = s(0)
      suffixes get leading match {
        case None =>
          suffixes = suffixes + (leading -> empty)
        case _ =>
      }
      suffixes(leading) withPrefix (s substring 1)
    }

  def iterator: Iterator[(String, A)] =
    (for (v <- value.iterator) yield ("", v)) ++
      (for ((chr, m) <- suffixes.iterator;
            (s, v) <- m.iterator) yield (chr +: s, v))

  override def className = "PrefixMap"

  // Overload methods to return PrefixMap
  def map[B](f: ((String, A)) => (String, B)): PrefixMap[B] =
    strictOptimizedMap(PrefixMap.newBuilder[B], f)

  def flatMap[B](f: ((String, A)) =>
    IterableOnce[(String, B)]): PrefixMap[B] =
    strictOptimizedFlatMap(PrefixMap.newBuilder[B], f)

  // Override concat to refine its return type
  def concat[B >: A](suffix:
                     Iterable[(String, B)]): PrefixMap[B] =
    strictOptimizedConcat(suffix, PrefixMap.newBuilder[B])

  // Members declared in scala.collection.mutable.Clearable
  override def clear(): Unit = suffixes = immutable.Map.empty

  // Members declared in scala.collection.IterableOps
  override protected def fromSpecific(
                                       source: IterableOnce[(String, A)]): PrefixMap[A] =
    PrefixMap.from(coll)

  override protected def newSpecificBuilder:
  mutable.Builder[(String, A), PrefixMap[A]] =
    PrefixMap.newBuilder

  override def empty: PrefixMap[A] = new PrefixMap
}


object PrefixMap {
  def empty[A] = new PrefixMap[A]

  def from[A](source: IterableOnce[(String, A)]): PrefixMap[A] =
    source match {
      case pm: PrefixMap[A] => pm
      case _ => (newBuilder[A] ++= source).result()
    }

  def apply[A](kvs: (String, A)*): PrefixMap[A] = from(kvs)

  def newBuilder[A]: mutable.Builder[(String, A), PrefixMap[A]] =
    new mutable.GrowableBuilder[(String, A), PrefixMap[A]](empty)

  implicit def toFactory[A](
                             self: this.type): Factory[(String, A), PrefixMap[A]] =
    new Factory[(String, A), PrefixMap[A]] {
      def fromSpecific(source:
                       IterableOnce[(String, A)]): PrefixMap[A] =
        self.from(source)

      def newBuilder: mutable.Builder[(String, A), PrefixMap[A]] =
        self.newBuilder
    }
}

