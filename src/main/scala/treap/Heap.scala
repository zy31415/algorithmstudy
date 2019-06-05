package treap

object Heap {
  def bubbleUp[T<:TreeNode with Priority](node: T): Unit = {
    assert(node != null)
    val parent = node.parent.asInstanceOf[T]

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
