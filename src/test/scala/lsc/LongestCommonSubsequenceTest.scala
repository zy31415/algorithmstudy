package lsc

import lcs.LongestCommonSubsequence
import org.scalatest.FunSuite

class LongestCommonSubsequenceTest extends FunSuite {

  test("test both emtpy ") {
    val l = LongestCommonSubsequence.get("","")
    assert(l==0)
  }

  test("test left emtpy ") {
    val l = LongestCommonSubsequence.get("","abc")
    assert(l==0)
  }

  test("test right emtpy ") {
    val l = LongestCommonSubsequence.get("abc","")
    assert(l==0)
  }

  test("test one") {
    val l = LongestCommonSubsequence.get("a","a")
    assert(l==1)
  }

  test("test one difference") {
    val l = LongestCommonSubsequence.get("a","b")
    assert(l==0)
  }

  test("test two") {
    val l = LongestCommonSubsequence.get("ab","ab")
    assert(l==2)
  }

  test("test different two") {
    val l = LongestCommonSubsequence.get("ab","cd")
    assert(l==0)
  }

  test("test two different one") {
    val l = LongestCommonSubsequence.get("ab","bc")
    assert(l==1)
  }

  test("test two different ") {
    val l = LongestCommonSubsequence.get("ab","ba")
    assert(l==1)
  }

  test("test 1") {
    val l = LongestCommonSubsequence.get("dabcdac","cbadac")
    assert(l==4)
  }

}
