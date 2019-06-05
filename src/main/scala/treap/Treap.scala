package treap

object Treap {
  def insert(root: Node, key: Int): Node = {
    val inserted = BST.insert(root, key)
    Heap.bubbleUp(inserted)
    inserted
  }

  def insert(root: Node, node: Node): Node = {
    val inserted = BST.insert(root, node)
    Heap.bubbleUp(inserted)
    inserted
  }
}
