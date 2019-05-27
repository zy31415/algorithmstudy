package bst

import org.scalatest.FunSuite

class PredecessorTest extends FunSuite {
  test("root only") {
    val root = new BST.Node(0)
    assert(BST.predecessor(root) == null)
  }

  test("two elements") {
    val root = new BST.Node(1)
    val node0 = BST.add(0, root)
    assert(BST.predecessor(root) == node0)
    assert(BST.predecessor(node0) == null)
  }

  test("two elements 2") {
    val root = new BST.Node(0)
    val node1 = BST.add(1, root)
    assert(BST.predecessor(root) == null)
    assert(BST.predecessor(node1) == root)
  }

  test("random") {
    val root = new BST.Node(0)
    val r = scala.util.Random
    (1 to 100).foreach(_=>BST.add(r.nextInt(5000), root))

    val arr = BST.sorted(root)
    var node = BST.maxNode(root)

    assert(arr.reverse.forall{
      a =>
        val res = a == node.value
        node = BST.predecessor(node)
        res
    })
  }
}
