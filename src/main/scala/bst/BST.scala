package bst

class BST[T: Ordering] {

  private val odr = implicitly(Ordering[T])

  class Node (val value: T) {
    var left: Node = _
    var right: Node = _
  }

  private[bst] var root: Node = _

  def add(element: T): Unit = {
    if (root == null)
      root = new Node(element)
    else
      add(element, root)
  }

  private def add(element: T, root: Node): Unit = {
    assert(root != null)

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

  def contains(element: T): Boolean = search(element).isDefined

  private def search(element: T): Option[Node] = {
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

  def sorted(): Seq[T] = {
    val list = Seq[T]()
    dfs(root, list)
  }

  private def dfs(node: Node, list: Seq[T]): Seq[T] = {
    if (node == null)
      list
    else {
      val out1 = dfs(node.left, list)
      val out2 = out1 :+ node.value
      dfs(node.right, out2)
    }
  }

  def max: Option[T] = {
    val res = maxNode
    if (res.isDefined)
      Some(res.get.value)
    else
      None
  }

  private def maxNode: Option[Node] = {
    if (root == null)
      return None
    var node = root
    while (node.right != null)
      node = node.right
    Some(node)
  }

  def min: Option[T] = {
    val res = minNode
    if (res.isDefined)
      Some(res.get.value)
    else
      None
  }

  private def minNode: Option[Node] = {
    if (root == null)
      return None
    var node = root
    while (node.left != null)
      node = node.left
    Some(node)
  }

  private def remove(element: T): Unit = {
    val nodeOption = search(element)

    if (nodeOption.isEmpty)
      return

    val node = nodeOption.get



  }
}
