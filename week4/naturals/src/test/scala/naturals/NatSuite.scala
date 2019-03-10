package naturals

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NatSuite extends FunSuite{

  test("Succ.from(0) is Zero ") {
    val sut = Succ.from(0)
    assert(sut.isZero)
  }

  test("Succ.from(1).pred is Zero ") {
    val sut = Succ.from(1).predecessor
    assert(sut.isZero)
  }

  test("Succ.from(5) - Succ.from(5) is Zero"){
    val sut = Succ.from(5) - Succ.from(5)
    assert(sut.isZero)
  }

  test("Succ.from(5) + Succ.from(5) is Succ[10]"){
    val sut = Succ.from(5) + Succ.from(5)
    assert(Succ.toInt(sut) == 10)
  }

}
