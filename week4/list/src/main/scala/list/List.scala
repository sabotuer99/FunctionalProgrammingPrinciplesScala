package list

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def nth(n: Int): T
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
  def nth(n: Int): T = if (n == 0) head else tail.nth(n - 1)
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  def nth(n: Int): Nothing = throw new IndexOutOfBoundsException("Nil.nth")
  override def equals(obj: Any): Boolean = obj.isInstanceOf[Nil[T]]
}

object List {
  def apply[T](a: T, b: T): Cons[T] = new Cons(a, new Cons(b, new Nil))
  def apply[T](a: T): Cons[T] = new Cons(a, new Nil)
  def apply[T](): Nil[T] = new Nil
}
