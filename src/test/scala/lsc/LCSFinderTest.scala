package lsc

import org.scalatest.FunSuite
import lcs.LCSFinder

class LCSFinderTest extends FunSuite {
  test("test") {
    val finder = new LCSFinder("ab","ab")
    println(finder.search())
  }

  test("test 2") {
    val finder = new LCSFinder("dabcdac","cbadac")
    println(finder.search())
  }
}
