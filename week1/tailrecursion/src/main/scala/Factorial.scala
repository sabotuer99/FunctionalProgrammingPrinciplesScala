package tailrecursion

object Factorial {

  def factorial(n: Int) = {

    def factIter(i: Int, total: BigInt): BigInt = {
      val newTotal = if (i==0) BigInt.apply(1) else i * total
      if (i == n) newTotal else factIter(i + 1, newTotal)
    }


    require(n >= 0, "Factorial is only defined over non-negative integers")
    factIter(0, 1)
  }
}

