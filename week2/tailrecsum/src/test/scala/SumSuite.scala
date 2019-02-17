package tailrecsum

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SumSuite extends FunSuite {

  import Sum.sum

  test("small range") {
    assert(sum(x => x)(3, 6) === 18)
  }
}
