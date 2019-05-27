package tree

class Node (val value: Int){
  var left: Node = _
  var right: Node = _
}

object Tree {
  def inorderTraverse(root: Node):Seq[Int] = {
    var res = Seq[Int]()
    var stack = List(root)

    while (stack.nonEmpty) {
      val node = stack.head
      stack = stack.drop(1)

      if (node.left == null && node.right == null)
        res = res :+ node.value
      else{
        if (node.right != null)
          stack = node.right +: stack

        stack = new Node(node.value) +: stack

        if (node.left != null)
          stack = node.left +: stack
      }
    }
    res
  }

  def inorderTraverse2(root: Node):Seq[Int] = {
    var res = Seq[Int]()

    if (root == null)
      return res

    var stack = List(root)
    stack = pushLeft(stack, root)

    while (stack.nonEmpty) {
      val node = stack.head
      stack = stack.drop(1)
      res = res :+ node.value

      if (node.right != null)
        stack = pushLeft(node.right +: stack, node.right)
    }
    res
  }

  private def pushLeft(stack: List[Node], node: Node): List[Node] = {
    var out = stack
    var cur = node.left
    while (cur != null) {
      out = cur +: out
      cur = cur.left
    }
    out
  }
}
