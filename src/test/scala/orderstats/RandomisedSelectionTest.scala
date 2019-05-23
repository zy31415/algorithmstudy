package orderstats

import org.scalatest.FunSuite

class RandomisedSelectionTest extends FunSuite {
  test("test one element") {
    val arr = Array(1)
    assert(RandomisedSelection.select(arr, 0) == 1)
  }
  test("test 1") {
    val arr = Array(1,2)
    assert(RandomisedSelection.select(arr, 0) == 1)
    assert(RandomisedSelection.select(arr, 1) == 2)
  }

  test("test two elements - 1") {
    val arr = Array(2,1)
    RandomisedSelection.seed = 0
    assert(RandomisedSelection.select(arr, 0) == 1)
  }

  test("test two elements - 2") {
    val arr = Array(2,1)
    RandomisedSelection.seed = 0
    assert(RandomisedSelection.select(arr, 1) == 2)
  }

  test("test three elements - 1") {
    val arr = Array(1,2,3)

    RandomisedSelection.seed = 1

    assert(RandomisedSelection.select(arr, 0) == 1)
    assert(RandomisedSelection.select(arr, 1) == 2)
    assert(RandomisedSelection.select(arr, 2) == 3)
  }

  test("test three elements - 2") {
    val arr = Array(3,1,2)
    RandomisedSelection.seed = 1
    assert(RandomisedSelection.select(arr, 0) == 1)
  }

  test("test three elements - 3") {
    val arr = Array(3,1,2)

    RandomisedSelection.seed = 1

    assert(RandomisedSelection.select(arr, 1) == 2)
    assert(RandomisedSelection.select(arr, 2) == 3)
  }

  test("test ten elements") {
    val arr = Array(3, 1, 2, 9, 7, 4, 6, 5, 8)

    RandomisedSelection.seed = 1
    assert(RandomisedSelection.select(arr, 0) == 1)
    assert(RandomisedSelection.select(arr, 1) == 2)
    assert(RandomisedSelection.select(arr, 4) == 5)
  }
}
