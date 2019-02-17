package tailrecsum

object Sum {
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + a)
    }
    loop(a, 0)
  }
}
