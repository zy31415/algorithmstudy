package graphs

import scala.collection.immutable
import scala.collection.mutable

class Node (val name: String, val neighbors: mutable.HashSet[Node] = mutable.HashSet())


object TopologicalSort {

  def sort(nodes: Seq[Node]):Seq[Node] = {
    dfs(nodes)
  }

  private def dfs(nodes: Seq[Node]): Seq[Node] = {
    val discovered: mutable.HashSet[Node] = mutable.HashSet()
    var orders = Seq[Node]()
    for (node <- nodes if !discovered.contains(node))
      orders ++= dfs_visit(node, discovered)
    orders
  }

  private def dfs_visit(node: Node, discovered: mutable.HashSet[Node]): Seq[Node] = {
    discovered.add(node)
    var orders = Seq[Node]()

    for (c <- node.neighbors if !discovered.contains(c))
      orders ++= dfs_visit(c, discovered)
    orders :+ node
  }
}
