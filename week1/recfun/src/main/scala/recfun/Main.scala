package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): BigInt = {
    def pascalIter(ci: Int, ri: Int, memo: Map[Int, BigInt]): BigInt = {
      val left = if (memo.contains(ci - 1)) memo(ci - 1) else BigInt(0)
      val right = if (memo.contains(ci)) memo(ci) else BigInt(0)
      val newMemo = if (ci == 0 || ci == ri) memo + (ci -> BigInt(1)) else memo + (ci -> (left + right))
      val nextRi = if (ci == 0) ri + 1 else ri
      val nextCi = if (ci == 0) r + c - ri else ci - 1
      if (ci == c && ri == r) newMemo(ci) else pascalIter(nextCi, nextRi, newMemo)
    }

    pascalIter(r + c, 0, Map())
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def balIter(chars: List[Char], score: Int): Boolean = {
      if (chars.isEmpty) return true
      val increment =
        if (chars.head == '(') 1
        else if (chars.head == ')') -1
        else 0
      (score + increment) >= 0 && balIter(chars.tail, score + increment)
    }

    balIter(chars, 0)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): BigInt = {
    val zero = BigInt(0)
    def ways(i: Int, memo: Map[Int, BigInt], subcoins: List[Int]): BigInt = {
      if (subcoins.isEmpty) return memo.getOrElse(money, zero)

      val coin = subcoins.head
      val newMemo = memo + (i -> (memo.getOrElse(i, zero) + memo.getOrElse(i - coin, zero)))
      val nexti = if(i == money) 0 else i + 1
      val nextSubcoins = if(i == money) subcoins.tail else subcoins
      ways(nexti, newMemo, nextSubcoins)
    }

    ways(0, Map(0 -> BigInt(1)), coins.sorted)
  }
}
