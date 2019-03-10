package expr


import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExprSuite extends FunSuite{

  test("Basic test Sum") {
    val lhs = Number(2)
    val rhs = Number(2)
    val sum = Sum(rhs, lhs)
    assert(sum.eval == 4)
  }

  test("Eval Nested Sum") {
    val lhs = Number(2)
    val rhs = Number(2)
    val sum = Sum(rhs, lhs)
    val topSum = Sum(sum, sum)
    assert(topSum.eval == 8)
  }

  test("Show Nested Sum") {
    val lhs = Number(2)
    val rhs = Number(2)
    val sum = Sum(rhs, lhs)
    val topSum = Sum(sum, sum)
    assert(topSum.show == "((2 + 2) + (2 + 2))")
  }

}
