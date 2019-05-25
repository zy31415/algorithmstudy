package heap.youngtableau

import org.scalatest.FunSuite

class SwapForwardTest extends FunSuite{
  test("size 1*1") {
    val tab = Array(Array(1))
    YoungTableau.swapForward(tab, (0, 0))
    assert(tab.deep == Array(Array(1)).deep)
  }

  test("size 1*2, no swap") {
    val tab = Array(Array(1, 2))
    YoungTableau.swapForward(tab, (0, 1))
    assert(tab.deep == Array(Array(1, 2)).deep)
  }

  test("size 1*2, swap") {
    val tab = Array(Array(2, 1))
    YoungTableau.swapForward(tab, (0, 1))
    assert(tab.deep == Array(Array(1, 2)).deep)
  }

  test("size 2*1, no swap") {
    val tab = Array(Array(1), Array(2))
    YoungTableau.swapForward(tab, (1, 0))
    assert(tab.deep == Array(Array(1), Array(2)).deep)
  }

  test("size 2*1, swap") {
    val tab = Array(Array(2), Array(1))
    YoungTableau.swapForward(tab, (1, 0))
    assert(tab.deep == Array(Array(1), Array(2)).deep)
  }

  test("size 2*2, no swap") {
    val tab = Array(Array(1, 3), Array(2, 4))
    YoungTableau.swapForward(tab, (1, 1))
    assert(tab.deep == Array(Array(1, 3), Array(2, 4)).deep)
  }

  test("size 2*2, swap once vertically") {
    val tab = Array(Array(1, 4), Array(3, 2))
    YoungTableau.swapForward(tab, (1, 1))
    assert(tab.deep == Array(Array(1, 2), Array(3, 4)).deep)
  }

  test("size 2*2, swap one horizontally") {
    val tab = Array(Array(1, 3), Array(4, 2))
    YoungTableau.swapForward(tab, (1, 1))
    assert(tab.deep == Array(Array(1, 3), Array(2, 4)).deep)
  }

  test("size 2*2, swap twice") {
    val tab = Array(Array(2, 3), Array(4, 1))
    YoungTableau.swapForward(tab, (1, 1))
    assert(tab.deep == Array(Array(1, 3), Array(2, 4)).deep)
  }
}
