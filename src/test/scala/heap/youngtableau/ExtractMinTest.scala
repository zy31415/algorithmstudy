package heap.youngtableau

import org.scalatest.FunSuite

class ExtractMinTest extends FunSuite{
  val inf = YoungTableau.inf
  test("test") {
    val tab = Array(Array(1, 3), Array(2, 4))
    var min = YoungTableau.extractMin(tab)
    assert(min == 1)
    assert(tab.deep == Array(Array(2, 3), Array(4, inf)).deep)

    min = YoungTableau.extractMin(tab)
    assert(min == 2)
    assert(tab.deep == Array(Array(3, inf), Array(4, inf)).deep)

    min = YoungTableau.extractMin(tab)
    assert(min == 3)
    assert(tab.deep == Array(Array(4, inf), Array(inf, inf)).deep)
  }
}
