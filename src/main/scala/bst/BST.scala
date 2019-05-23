package bst

class BST[T: Ordering] {

  class Node (val value: T) {
    var left: Node = _
    var right: Node = _
  }

  var root: Node = _

  def add(element: T): Unit = {
    val newNode = new Node(element)
    val odr = implicitly(Ordering[T])

    var parent: Node = null
    var child = root

    while (child != null) {
      parent = child
      child = if (odr.gt(element, child.value)) child.right else child.left
    }

    if (parent == null)
      root = newNode
    else if (odr.gt(element, parent.value))
      parent.right = newNode
    else
      parent.left = newNode
  }
}
