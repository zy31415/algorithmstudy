package treap

object Treap {
  def insert[T<:TreeNode with Key with Priority](root: T, key: Int): T = {
    val inserted = BST.insert(root, key)
    Heap.bubbleUp(inserted)
    inserted
  }

  def insert[T<:TreeNode with Key with Priority](root: T, node: T): T = {
    val inserted = BST.insert(root, node)
    Heap.bubbleUp(inserted)
    inserted
  }
}
