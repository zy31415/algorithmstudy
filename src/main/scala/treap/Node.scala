package treap

import scala.util.Random

class Node (val key: Int, val priority: Long = Random.nextLong()){
  var parent: Node = _
  var leftChild: Node = _
  var rightChild: Node = _
}
