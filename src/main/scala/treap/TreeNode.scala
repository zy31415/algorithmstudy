package treap

class TreeNode {
  var parent: TreeNode = _
  var leftChild: TreeNode = _
  var rightChild: TreeNode = _
}

object TreeNode {
  def apply: TreeNode = new TreeNode()
}

trait Key {
  var key: Int = 0
}

trait Priority {
  var priority: Int = 0
}