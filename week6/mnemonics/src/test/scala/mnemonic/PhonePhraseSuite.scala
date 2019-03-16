package mnemonic

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PhonePhraseSuite extends FunSuite{
  val pp = new PhonePhrase

  test("encode lecture example"){
    val phrases = pp.translate("7225247386")
    print(phrases)
    assert(phrases.contains("Scala is fun"))
  }

  test("wordCode"){
    assert(pp.wordCode("scala") == "72252")
  }

  test("wordsForNum"){
    val words = pp.wordsForNum("5282")
    print(words)
    assert(words.contains("Java"))
    assert(words.contains("lava"))
  }

}
