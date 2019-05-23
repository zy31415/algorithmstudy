package lcs

import scala.math.max
import Array.ofDim

object LongestCommonSubsequence {

  var cache: Array[Array[Int]] = Array.empty

  def get(s1: String, s2: String): Int= {
    initCache(s1.length, s2.length)
    get(s1, 0, s2, 0)
  }

  private def initCache(n1: Int, n2: Int): Unit = {
    // cache
    cache = ofDim[Int](n1, n2)

    for {
      i <- 0 until n1
      j <- 0 until n2
    } cache(i)(j) = -1
  }

  private def get(s1: String, n1: Int, s2: String, n2: Int): Int = {
    var l1 = s1.length - 1
    var l2 = s2.length - 1

    if (n1 > l1 || n2 > l2)
      return 0

    if (cache(n1)(n2) != -1)
      return cache(n1)(n2)

    var m = 0

    for (i1 <- n1 to l1) {
      var i2 = n2
      while (i2 <= l2) {
        if (s1(i1) == s2(i2)){
          m = max(m, 1 + get(s1, i1+1, s2, i2+1))
          l2 = i2
        }
        i2 += 1
      }
    }
    cache(n1)(n2) = m
    m
  }
}
