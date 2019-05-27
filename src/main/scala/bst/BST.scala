package bst

object BST {

  class Node[T: Ordering](val value: T) {
    var left: Node[T] = _
    var right: Node[T] = _
    var parent: Node[T] = _
  }

  def add[T: Ordering](element: T, root: Node[T]): Unit = {
    assert(root != null)
    val odr=implicitly(Ordering[T])
    if (odr.gt(element, root.value)) {
      if (root.right == null)
        root.right = new Node(element)
      else
        add(element, root.right)
    } else {
      if (root.left == null)
        root.left = new Node(element)
      else
        add(element, root.left)
    }
  }

  def contains[T: Ordering](element: T, root: Node[T]): Boolean = search(element, root).isDefined

  def search[T: Ordering](element: T, root: Node[T]): Option[Node[T]] = {
    val odr=implicitly(Ordering[T])
    var node = root
    while (node != null) {
      if (odr.equiv(node.value, element))
        return Some(node)
      if (odr.gt(element, node.value))
        node = node.right
      else
        node = node.left
    }
    None
  }

  def sorted[T:Ordering](root: Node[T]): Seq[T] = {
    val list = Seq[T]()
    dfs(root, list)
  }

  private def dfs[T:Ordering](node: Node[T], list: Seq[T]): Seq[T] = {
    if (node == null)
      list
    else {
      val out1 = dfs(node.left, list)
      val out2 = out1 :+ node.value
      dfs(node.right, out2)
    }
  }

  def maxNode[T](root: Node[T]): Node[T] = {
    assert(root != null)
    var node = root
    while (node.right != null)
      node = node.right
    node
  }

  def minNode[T:Ordering](root: Node[T]): Node[T] = {
    assert(root != null)
    var node = root
    while (node.left != null)
      node = node.left
    node
  }

  private def remove[T:Ordering](element: T, root: Node[T]): Unit = {
    val nodeOption = search(element, root)
    if (nodeOption.isEmpty)
      return
    val node = nodeOption.get
  }

  def successor[T:Ordering](node: Node[T]): Node[T] = {
    if (node.right != null)
      minNode(node.right)
    else {
      var c = node
      while (c.parent != null){
        if (c.parent.left == c.parent)
          return c.parent
        c = c.parent
      }
      null
    }
  }
}
