package bst

import org.scalatest.FunSuite

class BSTAddElementsTest extends FunSuite{
  test("test - root") {
    val root = new BST.Node(1)

    assert(root.value == 1)
    assert(root.right == null)
    assert(root.left == null)
  }

  test("test - two elements") {
    val root = new BST.Node(1)
    BST.add(2, root)

    assert(root.value == 1)
    assert(root.right != null)
    assert(root.left == null)

    assert(root.right.value == 2)
    assert(root.right.left == null)
    assert(root.right.right == null)
  }

  test("test - three elements") {
    val root = new BST.Node(2)

    BST.add(1, root)
    BST.add(3, root)

    assert(root.value == 2)
    assert(root.right != null)
    assert(root.left != null)

    assert(root.right.value == 3)
    assert(root.right.left == null)
    assert(root.right.right == null)

    assert(root.left.value == 1)
    assert(root.left.left == null)
    assert(root.left.right == null)

//    val arr = bst.sorted()
//    println(arr)

  }
}
