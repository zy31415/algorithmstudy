package bst

import org.scalatest.FunSuite

class BSTTest extends FunSuite {
  test("test - root") {
    val bst = new BST[Int]()
    bst.add(1)

    assert(bst.root.value == 1)
    assert(bst.root.right == null)
    assert(bst.root.left == null)
  }

  test("test - two elements") {
    val bst = new BST[Int]()
    bst.add(1)
    bst.add(2)

    assert(bst.root.value == 1)
    assert(bst.root.right != null)
    assert(bst.root.left == null)

    assert(bst.root.right.value == 2)
    assert(bst.root.right.left == null)
    assert(bst.root.right.right == null)
  }

  test("test - three elements") {
    val bst = new BST[Int]()
    bst.add(2)
    bst.add(1)
    bst.add(3)

    assert(bst.root.value == 2)
    assert(bst.root.right != null)
    assert(bst.root.left != null)

    assert(bst.root.right.value == 3)
    assert(bst.root.right.left == null)
    assert(bst.root.right.right == null)

    assert(bst.root.left.value == 1)
    assert(bst.root.left.left == null)
    assert(bst.root.left.right == null)

    val arr = bst.sorted()
    println(arr)

  }

  test("test - random build") {
    val bst = new BST[Int]()
    val r = scala.util.Random
    (1 to 100).foreach(_=>bst.add(r.nextInt(5000)))

    val arr = bst.sorted()

    assertIncreasing(arr)

  }

  test("test contains") {
    val bst = new BST[Int]()
    bst.add(2)
    assert(bst.contains(2))
  }

  test("test contains with random build") {
    val bst = new BST[Int]()
    val r = scala.util.Random
    (1 to 100).foreach(_=>bst.add(r.nextInt(5000)))
    assertIncreasing(bst.sorted())

    val a = r.nextInt(5000)
    bst.add(a)
    assert(bst.contains(a))

  }

  test("test max") {
    val bst = new BST[Int]()
    val r = scala.util.Random
    (1 to 100).foreach(_=>bst.add(r.nextInt(5000)))
    assert(bst.max.isDefined)
    assert(bst.sorted().last == bst.max.get)
  }

  test("test max of empty") {
    val bst = new BST[Int]()
    assert(bst.max.isEmpty)
  }

  def assertIncreasing[T: Ordering](arr: Seq[T]): Unit = {
    val ord = implicitly(Ordering[T])
    arr.indices.filter(_ < arr.length-1).foreach {
      n => assert(ord.gteq(arr(n+1), arr(n)))
    }
  }
}
