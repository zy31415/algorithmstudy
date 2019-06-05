package treap

import scala.util.Random

class Node (val key: Int, val priority: Long = Random.nextLong()){
  var parent: Node = _
  var leftChild: Node = _
  var rightChild: Node = _
}

class TreeNode {
  var parent: Node = _
  var leftChild: Node = _
  var rightChild: Node = _
}


trait Key {
  var key: Int = 0
}

trait Priority {
  var priority: Int = 0
}

