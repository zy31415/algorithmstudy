package orderstats

import org.scalatest.FunSuite

class SelectionTest extends FunSuite {
  test("test one") {
    val arr = Array(10)
    assert(Selection.select(arr, 0) == 10)
  }

  test("test two - 1") {
    val arr = Array(10, 20)
    assert(Selection.select(arr, 0) == 10)
    assert(Selection.select(arr, 1) == 20)
  }

  test("test two - 2") {
    val arr = Array(20, 10)
    assert(Selection.select(arr, 0) == 10)
    assert(Selection.select(arr, 1) == 20)
  }

  test("test ten elements") {
    val arr = Array(3, 1, 2, 9, 7, 4, 6, 5, 8)

    RandomisedSelection.seed = 1
    assert(Selection.select(arr, 0) == 1)
    assert(Selection.select(arr, 1) == 2)
    assert(Selection.select(arr, 4) == 5)
  }
}
