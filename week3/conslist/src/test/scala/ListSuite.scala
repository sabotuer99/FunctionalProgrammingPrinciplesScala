package conslist

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ListSuite extends FunSuite{

  test("basic list operations"){
    val a = new Cons("3", new Nil[String])
    val b = new Cons("2", a)
    val c = new Cons("1", b)
    val d = new Cons("0", c)

    assert(d.nth(0) == "0")
    assert(d.nth(1) == "1")
    assert(d.nth(2) == "2")
    assert(d.nth(3) == "3")

    intercept[IndexOutOfBoundsException] {
      d.nth(4)
    }
  }
}
