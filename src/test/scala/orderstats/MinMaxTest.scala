package orderstats

import org.scalatest.FunSuite

class MinMaxTest extends FunSuite {
  test("test 1") {
    val arr = Seq(3,4,2,5,7,8,9)
    assert(MinMax.minMax(arr) == (2, 9))
    assert(MinMax.minMax2(arr) == (2, 9))
  }
}
