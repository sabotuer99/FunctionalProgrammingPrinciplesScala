object session {


  def sqrt(x: Double): Double = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x))

    def isGoodEnough(guess: Double): Boolean =
      math.abs(1 - x / (guess * guess)) < 0.0000000001

    def improve(guess: Double): Double =
      (guess + (x / guess)) / 2.0

    sqrtIter(1, x)
  }

  val s = sqrt(2)

}

session.s
session.sqrt(1e-6)
session.sqrt(1e60)