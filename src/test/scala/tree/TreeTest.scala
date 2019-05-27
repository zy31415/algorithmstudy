package tree

import org.scalatest.FunSuite

class TreeTest extends FunSuite{
  test("traverse") {
    val root = new Node(1)
    root.left = new Node(0)
    root.right = new Node(2)
    Tree.inorderTraverse(root).foreach(println(_))
  }

  test("traverse2") {
    val root = new Node(1)
    root.left = new Node(0)
    root.right = new Node(2)
    Tree.inorderTraverse2(root).foreach(println(_))
  }
}
