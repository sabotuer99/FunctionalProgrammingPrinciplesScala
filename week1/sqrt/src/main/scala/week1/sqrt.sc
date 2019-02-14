object session {
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def isGoodEnough(guess: Double, x: Double): Boolean =
    math.abs(guess - (x/guess)) < 0.00000000000001

  def improve(guess: Double, x: Double): Double =
    (guess + (x/guess)) / 2.0

  def sqrt(x: Double): Double =
    sqrtIter(1, x)

  val s = sqrt(2)

}

session.s
session.isGoodEnough(1,2)
session.improve(1,2)