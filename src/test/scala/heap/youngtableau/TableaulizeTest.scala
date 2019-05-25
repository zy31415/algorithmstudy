package heap.youngtableau

import org.scalatest.FunSuite

import scala.util.Random

class TableaulizeTest extends FunSuite {
  test("random, size 3*3") {
    val arr = Array.fill(3, 3)(Random.nextInt(10))
    YoungTableau.tableaulize(arr)
    assert(YoungTableau.isYoungTableau(arr))
  }

  test("random, size 30*30") {
    val arr = Array.fill(30, 30)(Random.nextInt(100000))
    YoungTableau.tableaulize(arr)
    assert(YoungTableau.isYoungTableau(arr))
  }

  test("random, size 3*30") {
    val arr = Array.fill(3, 30)(Random.nextInt(100000))
    YoungTableau.tableaulize(arr)
    assert(YoungTableau.isYoungTableau(arr))
  }

  test("random, size 30*3") {
    val arr = Array.fill(30, 3)(Random.nextInt(100000))
    YoungTableau.tableaulize(arr)
    assert(YoungTableau.isYoungTableau(arr))
  }
}
