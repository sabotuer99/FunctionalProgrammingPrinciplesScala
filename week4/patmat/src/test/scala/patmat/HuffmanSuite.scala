package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
	trait TestTrees {
		val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
		val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
	}


  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }


  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("time with one letter repeated"){
    val test = string2Chars("aaaaa")
    val sut = times(test)
    assert(sut.toMap.apply('a') == 5)
  }

  test("time with several letter repeated"){
    val test = string2Chars("ababababaecdcdc")
    val sut = times(test)
    assert(sut.toMap.apply('a') == 5)
    assert(sut.toMap.apply('b') == 4)
    assert(sut.toMap.apply('c') == 3)
    assert(sut.toMap.apply('d') == 2)
    assert(sut.toMap.apply('e') == 1)
  }

  test("generic until test"){
    val over100 = (x: Int) => x > 100
    val double = (x: Int) => x * 2
    val test = until(over100,double)(10)
    // 10 -> 20 -> 40 -> 80 -> 160
    assert(test == 160)
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }


  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }


  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("Tell me your secret, Frenchie!"){
    val secret = decodedSecret
    assert(secret.mkString("") == "huffmanestcool")
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

}
