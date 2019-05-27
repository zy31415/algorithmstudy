package bst

object BST {

  class Node[T](val value: T) {
    var left: Node[T] = _
    var right: Node[T] = _
    var parent: Node[T] = _
  }

  def add[T: Ordering](element: T, root: Node[T]): Node[T] = {
    assert(root != null)
    val odr=implicitly(Ordering[T])
    if (odr.gt(element, root.value)) {
      if (root.right == null){
        val newNode = new Node(element)
        root.right = newNode
        newNode.parent = root
        newNode
      } else
        add(element, root.right)
    } else {
      if (root.left == null){
        val newNode = new Node(element)
        root.left = newNode
        newNode.parent = root
        newNode
      }
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

  def sorted[T](root: Node[T]): Seq[T] = {
    val list = Seq[T]()
    dfs(root, list)
  }

  private def dfs[T](node: Node[T], list: Seq[T]): Seq[T] = {
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

  def minNode[T](root: Node[T]): Node[T] = {
    assert(root != null)
    var node = root
    while (node.left != null)
      node = node.left
    node
  }

  def remove[T](node: Node[T]): Node[T] = {
    if (node.left == null){
      // todo: How do you handle this?
      assert(node != null)
      transplant(node, node.right)
    }
    else if (node.right == null)
      transplant(node, node.left)
    else if (node.left == null && node.right != null)
      transplant(node, node.right)
    else {
      val suc = successor(node)
      val sucParent = suc.parent

      if (sucParent != node){
        transplant(suc, suc.right)
        suc.right = node.right
        suc.right.parent = suc
      }

      transplant(node, suc)
      suc.left = node.left
      suc.left.parent = suc

      node.parent
    }
  }

  private def transplant[T](u: Node[T], v: Node[T]): Node[T]  = {
    val p = u.parent
    assert(p != null)

    if (p.left == u)
      p.left = v
    else
      p.right = v

    if (v != null)
      v.parent = p

    u.parent = null
    p
  }

  def successor[T](node: Node[T]): Node[T] = {
    if (node.right != null)
      minNode(node.right)
    else {
      var c = node
      while (c.parent != null){
        if (isLeftChild(c))
          return c.parent
        c = c.parent
      }
      null
    }
  }

  def predecessor[T](node: Node[T]): Node[T] = {
    assert(node != null)
    if (node.left != null)
      maxNode(node.left)
    else {
      var c = node
      while (c.parent != null) {
        if (isRightChild(c))
          return c.parent
        c = c.parent
      }
      null
    }

  }

  def isLeftChild[T](node: Node[T]): Boolean = {
    assert(node != null)
    node.parent != null && node.parent.left == node
  }

  def isRightChild[T](node: Node[T]): Boolean = {
    assert(node != null)
    node.parent != null && node.parent.right == node
  }

  def isRoot[T](node: Node[T]): Boolean = {
    assert(node != null)
    node.parent == null
  }
}
