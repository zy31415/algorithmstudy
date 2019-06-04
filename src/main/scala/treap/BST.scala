package treap

import scala.util.Random

object BST {
  def insert(root: Node, key: Int, priority: Long = Random.nextLong()): Node = {
    val inserted = new Node(key, priority)
    if (root == null)
      inserted
    else {
      var p = root
      var c = if (key > root.key) root.rightChild else root.leftChild

      while (c != null) {
        p = c
        c = if (key > p.key) p.rightChild else p.leftChild
      }

      inserted.parent = p

      if (key > p.key) {
        p.rightChild = inserted
      } else {
        p.leftChild = inserted
      }

      inserted
    }
  }
}
