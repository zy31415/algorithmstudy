package treap

import org.scalatest.FunSuite

class TreapTest extends FunSuite{
  test ("left/right rotate root") {
    val root = Treap.insert(null, 2)
    Treap.insert(root, 1)
    Treap.insert(root, 3)
    Treap.rightRotate(root)
    Treap.leftRotate(root)
    println("")
  }

  test ("right rotate leftChild") {
    val root = Treap.insert(null, 2)
    val left = Treap.insert(root, 1)
    Treap.insert(root, 3)
    Treap.rightRotate(left)
    println("")
  }
}
