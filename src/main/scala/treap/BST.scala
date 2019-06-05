package treap

object BST {

  def insert[T<:TreeNode with Key](root: T, key: Int): T = {
    val node = new TreeNode with Key
    node.key = key
    insert(root, node.asInstanceOf[T])
  }

  def insert[T<:TreeNode with Key](root: T, node: T): T = {
    val inserted = node
    val key = node.key

    if (root == null)
      inserted
    else {
      var p = root
      var c = if (key > root.key) root.rightChild.asInstanceOf[T] else root.leftChild.asInstanceOf[T]

      while (c != null) {
        p = c
        c = if (key > p.key) p.rightChild.asInstanceOf[T] else p.leftChild.asInstanceOf[T]
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
