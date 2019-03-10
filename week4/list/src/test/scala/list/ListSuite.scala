package list


import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ListSuite extends FunSuite{

  test("List(1,2).head == 1") {
    val sut = List(1,2)
    assert(sut.head == 1)
  }

  test("List(2).head == 2") {
    val sut = List(2)
    assert(sut.head == 2)
  }

  test("List() == Nil") {
    val sut = List()
    assert(sut == new Nil)
  }

}
