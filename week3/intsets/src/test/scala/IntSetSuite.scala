package intsets


import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class IntSetSuite extends FunSuite{

  test("toString on single node set") {
    val sut = new NonEmpty(1, Empty, Empty)
    assert(sut.toString() === "{.1.}")
  }

  test("toString on 3 node set") {
    val sut = new NonEmpty(1, Empty, Empty).incl(2).incl(3)

    assert(sut.toString() === "{.1{.2{.3.}}}")
  }

  test("toString on 3 node set, different order") {
    val sut = new NonEmpty(2, Empty, Empty).incl(1).incl(3)

    assert(sut.toString() === "{{.1.}2{.3.}}")
  }

  test("including same element has no effect") {
    val sut = new NonEmpty(1, Empty, Empty).incl(1).incl(1)

    assert(sut.toString() === "{.1.}")
  }

  test("union dissimilar sets") {
    val sut1 = new NonEmpty(1, Empty, Empty).incl(3).incl(5)
    val sut2 = new NonEmpty(2, Empty, Empty).incl(4).incl(6)
    val sutU = sut1 union sut2

    assert(sutU.toString() === "{{.1.}2{{.3.}4{{.5.}6.}}}")
  }

  test("union similar sets no duplicate elements") {
    val sut1 = new NonEmpty(1, Empty, Empty).incl(2).incl(3)
    val sut2 = new NonEmpty(2, Empty, Empty).incl(1).incl(3)
    val sutU = sut1 union sut2

    assert(sutU.toString() === "{{.1.}2{.3.}}")
  }

}
