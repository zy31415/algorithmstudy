package bst

import org.scalatest.FunSuite
import bst.BST.{Node, add, remove}

class RemoveTest extends FunSuite {

  test("deleted node has no children") {
    val node0 = new Node(0)
    val node1 = add(1, node0)
    remove(node1)
    assert(node0.left == null)
    assert(node0.right == null)
    assert(node1.parent == null)
  }

  test("deleted node has right child only") {
    /*
         0
          \
           1 (-)
            \
             2
 */
    val node0 = new Node(0)
    val node1 = add(1, node0)
    val node2 = add(2, node0)

    remove(node1)

    assert(node0.left == null)
    assert(node0.right == node2)
    assert(node2.parent == node0)
    assert(node1.parent == null)
  }

  test("deleted node has right child only 2") {
    /*
        3
       /
      1 (-)
       \
        2
*/
    val node3 = new Node(3)
    val node1 = add(1, node3)
    val node2 = add(2, node3)

    remove(node1)

    assert(node3.left == node2)
    assert(node3.right == null)
    assert(node2.parent == node3)
    assert(node1.parent == null)
  }

  test("deleted node has left child only") {
    /*
                3               3
               /               /
              2 (-)     =>    1
             /
            1
     */
    val node3 = new Node(3)
    val node2 = add(2, node3)
    val node1 = add(1, node3)

    remove(node2)

    assert(node3.left == node1)
    assert(node3.right == null)
    assert(node1.parent == node3)
    assert(node2.parent == null)
  }

  test("deleted node has left child only 2") {
    /*
          1                1
           \                \
            3 (-)   =>      2
           /
          2
    */
    val node1 = new Node(1)
    val node3 = add(3, node1)
    val node2 = add(2, node1)

    remove(node3)

    assert(node1.left == null)
    assert(node1.right == node2)
    assert(node2.parent == node1)
    assert(node3.parent == null)
  }

  test("deleted node has both left and right child 1") {
    /*
          1                1
           \                \
            3 (-)   =>      4
           / \             /
          2   4           2
    */
    val node1 = new Node(1)
    val node3 = add(3, node1)
    val node2 = add(2, node1)
    val node4 = add(4, node1)

    remove(node3)

    assert(node1.left == null)
    assert(node1.right == node4)
    assert(node4.parent == node1)
    assert(node4.left == node2)
    assert(node2.parent == node4)
    assert(node3.parent == null)
  }

  test("deleted node has both left and right child 2") {
    /*
          1                1
           \                \
            3 (-)   =>      4
           / \             / \
          2   4           2   5
               \
                5
    */
    val node1 = new Node(1)
    val node3 = add(3, node1)
    val node2 = add(2, node1)
    val node4 = add(4, node1)
    val node5 = add(5, node1)

    remove(node3)

    assert(node1.left == null)
    assert(node1.right == node4)

    assert(node4.parent == node1)
    assert(node4.left == node2)
    assert(node4.right == node5)

    assert(node2.parent == node4)

    assert(node3.parent == null)
  }

  test("deleted node has both left and right child 3") {
    /*
          1                1
           \                \
            3 (-)   =>      4
           / \             / \
          2   6           2   6
             /
            4
    */
    val node1 = new Node(1)
    val node3 = add(3, node1)
    val node2 = add(2, node1)
    val node6 = add(6, node1)
    val node4 = add(4, node1)

    remove(node3)

    assert(node1.left == null)
    assert(node1.right == node4)

    assert(node4.parent == node1)
    assert(node4.left == node2)
    assert(node4.right == node6)

    assert(node2.parent == node4)

    assert(node6.parent == node4)

    assert(node3.parent == null)
  }

  test("deleted node has both left and right child 4") {
    /*
          1                1
           \                \
            3 (-)   =>      4
           / \             / \
          2   6           2   6
             /               /
            4               5
             \
             5
    */
    val node1 = new Node(1)
    val node3 = add(3, node1)
    val node2 = add(2, node1)
    val node6 = add(6, node1)
    val node4 = add(4, node1)
    val node5 = add(5, node1)

    remove(node3)

    assert(node1.left == null)
    assert(node1.right == node4)

    assert(node4.parent == node1)
    assert(node4.left == node2)
    assert(node4.right == node6)

    assert(node2.parent == node4)

    assert(node6.parent == node4)
    assert(node6.left == node5)

    assert(node5.parent == node6)

    assert(node3.parent == null)
  }
}
