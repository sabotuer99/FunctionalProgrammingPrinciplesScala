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

}
