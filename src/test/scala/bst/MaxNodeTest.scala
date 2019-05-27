package bst

import org.scalatest.FunSuite

class MaxNodeTest extends FunSuite{
  test("test max of root") {
    val root = new BST.Node(0)
    assert(BST.maxNode(root) == root)
  }

  test("test max") {
    val root = new BST.Node(0)
    val r = scala.util.Random
    (1 to 100).foreach(_=>BST.add(r.nextInt(5000), root))
    assert(BST.sorted(root).last == BST.maxNode(root).value)
  }
}
