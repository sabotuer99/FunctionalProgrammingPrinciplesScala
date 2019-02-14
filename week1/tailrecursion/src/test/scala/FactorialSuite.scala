package tailrecursion

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FactorialSuite extends FunSuite {

  import Factorial._

  test("small factorial") {
    assert(factorial(3) === 6)
  }

  test("big factorial") {
    assert(factorial(10) === 3628800)
  }

  test("zero factorial") {
    assert(factorial(0) === 1)
  }

  test("negative value throws IllegalArgumentException") {
    intercept[IllegalArgumentException] {
      factorial(-3)
    }
  }
}
