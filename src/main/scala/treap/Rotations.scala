package treap

object Rotations {
  def leftRotate[T<:TreeNode](x: T): T = {
    // Assume that x has right child.
    assert(x.rightChild != null)
    val y = x.rightChild.asInstanceOf[T]

    // Step 1
    y.parent = x.parent
    if (x.parent != null) {
      if(x.parent.leftChild == x)
        x.parent.leftChild = y
      else
        x.parent.rightChild = y
    }

    // Step 2
    x.rightChild = y.leftChild
    if (y.leftChild != null)
      y.leftChild.parent = x

    // Step 3
    y.leftChild = x
    x.parent = y

    y
  }

  def rightRotate[T<:TreeNode](y: T): T = {
    // Assume y has left child.
    assert(y.leftChild != null)
    val x = y.leftChild.asInstanceOf[T]

    // Step 1
    x.parent = y.parent
    if (y.parent != null) {
      if (y.parent.leftChild == y)
        y.parent.leftChild = x
      else
        y.parent.rightChild = x
    }

    // Step 2
    y.leftChild = x.rightChild
    if (x.rightChild != null)
      x.rightChild.parent = y

    // Step 3
    x.rightChild = y
    y.parent = x

    x
  }
}
