package treap

import org.scalatest.FunSuite

class RotationsTest extends FunSuite{
  /*
            2
             \
              3
   */
  test("left rotation - 2 nodes") {
    val node2 = new Node(2)
    val node3 = BST.insert(node2, 3)

    val n = Rotations.leftRotate(node2)

    assert(n == node3)
    assert(node3.leftChild == node2)
    assert(node3.rightChild == null)
    assert(node3.parent == null)

    assert(node2.parent == node3)
    assert(node2.leftChild == null)
    assert(node2.rightChild == null)

  }

  /*
            3
           /
          2
   */
  test("right rotation - 2 nodes") {
    val node3 = new Node(3)
    val node2 = BST.insert(node3, 2)

    val n = Rotations.rightRotate(node3)

    assert(n == node2)
    assert(node2.leftChild == null)
    assert(node2.rightChild == node3)
    assert(node2.parent == null)

    assert(node3.parent == node2)
    assert(node3.leftChild == null)
    assert(node3.rightChild == null)
  }

  /*
            2                       4
             \    left Rotate      /
              4  ==============>  2
             /                     \
            3                       3
   */
  test("left rotation - 3 nodes") {
    val node_2 = new Node(2)
    val node_4 = BST.insert(node_2, 4)
    val node_3 = BST.insert(node_2, 3)

    val n = Rotations.leftRotate(node_2)

    assert(n == node_4)

    assert(node_4.leftChild == node_2)
    assert(node_4.rightChild == null)
    assert(node_4.parent == null)

    assert(node_2.parent == node_4)
    assert(node_2.leftChild == null)
    assert(node_2.rightChild == node_3)

    assert(node_3.leftChild == null)
    assert(node_3.rightChild == null)
    assert(node_3.parent == node_2)
  }

  /*
            2                       4
             \    right Rotate     /
              4  <=============  2
             /                     \
            3                       3
   */
  test("right rotation - 3 nodes") {
    val node_4 = new Node(4)
    val node_2 = BST.insert(node_4, 2)
    val node_3 = BST.insert(node_4, 3)

    val n = Rotations.rightRotate(node_4)

    assert(n == node_2)

    assert(node_4.leftChild == node_3)
    assert(node_4.rightChild == null)
    assert(node_4.parent == node_2)

    assert(node_2.parent == null)
    assert(node_2.leftChild == null)
    assert(node_2.rightChild == node_4)

    assert(node_3.leftChild == null)
    assert(node_3.rightChild == null)
    assert(node_3.parent == node_4)
  }
}
