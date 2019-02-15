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
    def pascalIter(ci: Int, ri: Int, memo: Map[String, BigInt]): BigInt = {
      val key = makeKey(ci, ri)
      if (memo.contains(key)) return memo(key)

      val leftKey = makeKey(ci - 1, ri - 1)
      val rightKey = makeKey(ci, ri - 1)
      val left = if (memo.contains(leftKey)) memo(leftKey) else BigInt.apply(0)
      val right = if (memo.contains(rightKey)) memo(rightKey) else BigInt.apply(0)
      val thisCell = left + right
      val newMemo = if (ci == 0 || ci == ri) memo + (key -> BigInt.apply(1)) else memo + (key -> thisCell)

      if (ci == c && ri == r) return newMemo(key)

      val nextRi = if (ci == 0) ri + 1 else ri
      val nextCi = if (ci == 0) r + c - ri else ci - 1
      pascalIter(nextCi, nextRi, newMemo)
    }

    def makeKey(c: Int, r: Int): String = {
      c.toString + "_" + r.toString
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
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeIter(money: Int, coins: List[Int]): Int = {
      val usableCoins = coins.filter(_ <= money)
      if (usableCoins.count(_ == money) == usableCoins.length) usableCoins.length
      else countChangeIter(money, usableCoins.tail) + countChangeIter(money - usableCoins.head, usableCoins.tail)
    }

    countChangeIter(money, coins.sorted)
  }
}
