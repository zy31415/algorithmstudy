package bst

import org.scalatest.FunSuite
import utils.TestUtils.assertAscending

class BSTSortTest extends FunSuite{

  test("test - two elements") {
    val root = new BST.Node(1)
    BST.add(2, root)

    val arr = BST.sorted(root)
    assertAscending(arr)
  }

  test("test - three elements") {
    val root = new BST.Node(2)
    
    BST.add(1, root)
    BST.add(3, root)

    val arr = BST.sorted(root)
    assertAscending(arr)
  }

    test("test - random build") {
      val root = new BST.Node(0)
      val r = scala.util.Random
      (1 to 100).foreach(_=>BST.add(r.nextInt(5000), root))

      val arr = BST.sorted(root)

      assertAscending(arr)

    }
}
