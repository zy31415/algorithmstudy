package treap

object Heap {
  def bubbleUp(node: Node): Unit = {
    assert(node != null)
    val parent = node.parent

    if (parent != null && parent.priority < node.priority) {
      val next =
        if (parent.rightChild == node)
          Rotations.leftRotate(parent)
        else
          Rotations.rightRotate(parent)
      bubbleUp(next)
    }
  }
}
