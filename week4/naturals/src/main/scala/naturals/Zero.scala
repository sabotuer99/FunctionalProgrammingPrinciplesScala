package naturals

object Zero extends Nat{
  override def isZero: Boolean = true

  override def predecessor: Nat = throw new NoSuchElementException("Zero.predecessor")

  override def successor: Nat = new Succ(this)

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = if (that.isZero) that else throw new NoSuchElementException("Zero - Succ")

  override def toString(): String = "Zero[0]"
}
