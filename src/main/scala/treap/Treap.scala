package treap

import scala.util.Random

object Treap {

  class Node (val key: Int) {
    var parent: Node = _
    var leftChild: Node = _
    var rightChild: Node = _
    var priority = Random.nextLong()
  }

  def insert(root: Node, key: Int): Node = {
    null
//    val inserted = treeInsert(root, key)
//    heapify(inserted)
//    inserted
  }

  private def heapify(node: Node): Unit = {
//    var parent = node.parent
//    while (parent != null && node.priority > parent.priority) {
//      rotate(node)
//      // Got a new parent
//      parent = node.parent
//    }
  }

  private def rotate(node: Node): Unit = {
    val parent = node.parent
    if (parent.leftChild == node)
      rightRotate(node)
    else
      leftRotate(node)
  }

  private[treap] def rightRotate(node: Node): Unit = {
    val parent = node.parent

    if (parent == null)
      return

    // Step one
    transplant(parent, node)

    // Step two
    val beta = node.rightChild

    if (beta == null) {
      node.rightChild = parent
      parent.parent = node
    } else
      transplant(beta, parent)

    // Step three
    transplant(node, beta)

  }

  private[treap] def leftRotate(node: Node): Unit = {
    val parent = node.parent

    if (parent == null)
      return

    // Step one
    transplant(parent, node)

    // Step two
    val beta = node.leftChild

    if (beta == null) {
      node.leftChild = parent
      parent.parent = node
    } else
      transplant(beta, parent)

    // Step three
    transplant(node, beta)

  }

  private def transplant(u: Node, v:Node): Unit = {
    if (u.parent != null) {
      if (u.parent.leftChild == u)
        u.parent.leftChild = v
      else
        u.parent.rightChild = v
    }
    v.parent = u.parent
  }
}
