package naturals

class Succ(pred: Nat) extends Nat{
  override def isZero: Boolean = false

  override def predecessor: Nat = pred

  override def successor: Nat = new Succ(this)

  override def +(that: Nat): Nat = if (that.isZero) this else this.successor + that.predecessor

  override def -(that: Nat): Nat = if (that.isZero) this else this.predecessor - that.predecessor

  override def toString(): String = "Succ[" + Succ.toInt(this).toString + "]"
}

object Succ {
  def from(n: Int): Nat = {
    require(n >= 0)
    if (n == 0) Zero
    else new Succ(from(n - 1))
  }

  def toInt(nat: Nat): Int = {
    if (nat.isZero) 0
    else 1 + toInt(nat.predecessor)
  }
}
