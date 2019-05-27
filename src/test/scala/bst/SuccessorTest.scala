package bst

import org.scalatest.FunSuite

class SuccessorTest extends FunSuite {
  test("successor - root only") {
    val root = new BST.Node(0)
    assert(BST.successor(root) == null)
  }

  test("successor - two elements") {
    val root = new BST.Node(0)
    BST.add(1, root)
    assert(BST.successor(root).value == 1)
    assert(BST.successor(BST.successor(root)) == null)
  }

  test("successor - two elements 2") {
    val root = new BST.Node(1)
    BST.add(0, root)
    assert(BST.successor(root) == null)
    assert(BST.successor(root.left) == root)
  }

  test("successor - null") {
    val root = new BST.Node(1)
    val node2 = BST.add(2, root)
    val node3 = BST.add(3, root)
    assert(BST.successor(root) == node2)
    assert(BST.successor(node2) == node3)
    assert(BST.successor(node3) == null)
  }

  test("random") {
    val root = new BST.Node(0)
    val r = scala.util.Random
    (1 to 100).foreach(_=>BST.add(r.nextInt(5000), root))

    val arr = BST.sorted(root)
    var node = root

    assert(arr.forall{
      a =>
        val res = a == node.value
        node = BST.successor(node)
        res
    })
  }
}
