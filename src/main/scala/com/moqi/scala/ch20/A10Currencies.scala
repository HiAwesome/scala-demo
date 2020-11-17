package com.moqi.scala.ch20

/**
 * 案例分析：货币
 *
 * @author moqi On 11/16/20 09:54
 */
object A10Currencies {

  def main(args: Array[String]): Unit = {

    func1

    func2
  }

  private def func2: Unit = {
    val j1 = Japan.Yen from US.Dollar * 100
    val e1 = Europe.Euro from j1
    val u1 = US.Dollar from e1
    val u2 = US.Dollar * 100 + u1
    println(s"j1 = ${j1}")
    println(s"e1 = ${e1}")
    println(s"u1 = ${u1}")
    println(s"u2 = ${u2}")

    /**
     * type mismatch;
     *  found   : com.moqi.scala.ch20.Europe.Euro
     *  required: com.moqi.scala.ch20.US.Currency
     *     (which expands to)  com.moqi.scala.ch20.US.Dollar
     *     val exception = US.Dollar + Europe.Euro
     */
    // val exception = US.Dollar + Europe.Euro
  }

  private def func1: Unit = {
    val c1 = new Currency {
      override val amount: Long = 79L

      override def designation = "UDS"

    }

    println(s"c1 = ${c1}")
    println()
  }
}

abstract class Currency {
  val amount: Long

  def designation: String

  override def toString: String = amount + " " + designation

  // def +(that: Currency): Currency

  // def *(x: Double): Currency
}

object US extends CurrencyZone {

  abstract class Dollar extends AbstractCurrency {
    def designation = "USD"
  }

  type Currency = Dollar

  def make(cents: Long): Dollar = new Dollar {
    val amount = cents
  }

  val Cent = make(1)
  val Dollar = make(100)
  val CurrencyUnit = Dollar
}

object Europe extends CurrencyZone {

  abstract class Euro extends AbstractCurrency {
    def designation = "EUR"
  }

  type Currency = Euro

  def make(cents: Long): Euro = new Euro {
    val amount = cents
  }

  val Cent = make(1)
  val Euro = make(100)
  val CurrencyUnit = Euro
}

object Japan extends CurrencyZone {

  abstract class Yen extends AbstractCurrency {
    def designation = "JPY"
  }

  type Currency = Yen

  def make(yen: Long): Yen = new Yen {
    val amount = yen
  }

  val Yen = make(1)
  val CurrencyUnit = Yen
}

object Converter {
  var exchangeRate = Map(
    "USD" -> Map("USD" -> 1.0, "EUR" -> 0.7596,
      "JPY" -> 1.211, "CHF" -> 1.223),
    "EUR" -> Map("USD" -> 1.316, "EUR" -> 1.0,
      "JPY" -> 1.594, "CHF" -> 1.623),
    "JPY" -> Map("USD" -> 0.8257, "EUR" -> 0.6272,
      "JPY" -> 1.0, "CHF" -> 1.018),
    "CHF" -> Map("USD" -> 0.8108, "EUR" -> 0.6160,
      "JPY" -> 0.982, "CHF" -> 1.0)
  )
}


abstract class CurrencyZone {

  type Currency <: AbstractCurrency

  def make(x: Long): Currency

  abstract class AbstractCurrency {

    val amount: Long

    def designation: String

    def +(that: Currency): Currency =
      make(this.amount + that.amount)

    def *(x: Double): Currency =
      make((this.amount * x).toLong)

    def -(that: Currency): Currency =
      make(this.amount - that.amount)

    def /(that: Double) =
      make((this.amount / that).toLong)

    def /(that: Currency) =
      this.amount.toDouble / that.amount

    def from(other: CurrencyZone#AbstractCurrency): Currency =
      make(math.round(
        other.amount.toDouble * Converter.exchangeRate
        (other.designation)(this.designation)))

    private def decimals(n: Long): Int =
      if (n == 1) 0 else 1 + decimals(n / 10)

    override def toString =
      ((amount.toDouble / CurrencyUnit.amount.toDouble)
        formatted ("%." + decimals(CurrencyUnit.amount) + "f")
        + " " + designation)
  }

  val CurrencyUnit: Currency
}