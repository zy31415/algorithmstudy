package treap

import org.scalatest.FunSuite

class TreapTest extends FunSuite{
  test("insertion - no rotation") {
    val node_2 = new Node(2, 10)
    val node_3 = new Node(3, 9)
    Treap.insert(node_2, node_3)

    assert(node_3.parent == node_2)
    assert(node_2.parent == null)
  }

  test("insertion - rotation") {
    val node_2 = new Node(2, 10)
    val node_3 = new Node(3, 11)
    Treap.insert(node_2, node_3)

    assert(node_2.parent == node_3)
    assert(node_3.parent == null)
  }
}
