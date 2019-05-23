package graphs

import org.scalatest.FunSuite

class TopologicalSortTest extends FunSuite {
  test("test") {
    var nodes = Seq[Node]()

    val undershorts = new Node("undershorts")
    nodes = nodes :+ undershorts

    val socks = new Node("socks")
    nodes = nodes :+ socks

    val pants = new Node("pants")
    nodes = nodes :+ pants

    val shoes = new Node("shoes")
    nodes = nodes :+ shoes

    val watch = new Node("watch")
    nodes = nodes :+ watch

    val belt = new Node("belt")
    nodes = nodes :+ belt

    val shirt = new Node("shirt")
    nodes = nodes :+ shirt

    val tie = new Node("tie")
    nodes = nodes :+ tie

    val jacket = new Node("jacket")
    nodes = nodes :+ jacket


    undershorts.neighbors.add(pants)
    undershorts.neighbors.add(shoes)

    socks.neighbors.add(shoes)

    pants.neighbors.add(belt)
    pants.neighbors.add(shoes)

    shirt.neighbors.add(belt)
    shirt.neighbors.add(tie)

    belt.neighbors.add(jacket)

    tie.neighbors.add(jacket)

    val sorted = TopologicalSort.sort(nodes)

    for ( s <- sorted)
      println(s.name)

  }
}
