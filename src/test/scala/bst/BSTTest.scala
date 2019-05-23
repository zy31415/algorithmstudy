package bst

import org.scalatest.FunSuite

class BSTTest extends FunSuite {
  test("test - root") {
    val bst = new BST[Int]()
    bst.add(1)

    assert(bst.root.value == 1)
    assert(bst.root.right == null)
    assert(bst.root.left == null)
  }

  test("test - two elements") {
    val bst = new BST[Int]()
    bst.add(1)
    bst.add(2)

    assert(bst.root.value == 1)
    assert(bst.root.right != null)
    assert(bst.root.left == null)

    assert(bst.root.right.value == 2)
    assert(bst.root.right.left == null)
    assert(bst.root.right.right == null)
  }

  test("test - three elements") {
    val bst = new BST[Int]()
    bst.add(2)
    bst.add(1)
    bst.add(3)

    assert(bst.root.value == 2)
    assert(bst.root.right != null)
    assert(bst.root.left != null)

    assert(bst.root.right.value == 3)
    assert(bst.root.right.left == null)
    assert(bst.root.right.right == null)

    assert(bst.root.left.value == 1)
    assert(bst.root.left.left == null)
    assert(bst.root.left.right == null)
  }
}
