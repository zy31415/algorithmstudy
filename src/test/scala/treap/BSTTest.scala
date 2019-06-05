package treap

import org.scalatest.FunSuite

class BSTTest extends FunSuite {

  test("insert - 1 node") {
    val node_1 = new TreeNode with Key {
      key = 1
    }

    val node_2 = new TreeNode with Key {
      key = 2
    }

    BST.insert(node_1, node_2)

  }

  test("insert value") {
    val node_1 = new TreeNode with Key {
      key = 1
    }

    BST.insert(node_1, 2)
  }

}
