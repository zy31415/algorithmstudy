package bst

import org.scalatest.FunSuite
import utils.TestUtils.assertAscending

class SearchTest extends FunSuite{
  test("test contains") {
    val root = new BST.Node(2)
    assert(BST.contains(2, root))
  }

  test("test contains with random build") {
    val root = new BST.Node(2)
    val r = scala.util.Random
    (1 to 100).foreach(_=>BST.add(r.nextInt(5000), root))
    assertAscending(BST.sorted(root))

    val a = r.nextInt(5000)
    BST.add(a, root)
    assert(BST.contains(a, root))
  }
}
