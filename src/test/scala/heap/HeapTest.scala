package heap

import org.scalatest.FunSuite

import scala.util.Random

class HeapTest extends FunSuite {
  test("empty array") {
    val arr = Array[Int]()
    Heap.maxHeapify(arr, 0)
  }

  test("array length = 1") {
    val arr = Array[Int](1)
    Heap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(1)))
  }

  test("array length = 2") {
    val arr = Array(1, 2)
    Heap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(2, 1)))
  }

  test("array length = 2, no swap") {
    val arr = Array(2, 1)
    Heap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(2, 1)))
  }

  test("array length = 3, right swap") {
    val arr = Array(1, 2, 3)
    Heap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(3, 2, 1)))
  }

  test("array length = 3, left swap") {
    val arr = Array(1, 3, 2)
    Heap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(3, 1, 2)))
  }

  test("array length = 3, no swap") {
    val arr = Array(3, 1, 2)
    Heap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(3, 1, 2)))
  }

  test("array length=10") {
    val arr = Array(16, 4, 10, 14, 7, 9, 3, 2, 8, 1)
    Heap.maxHeapify(arr, 1)
    assert(arr.sameElements(Array(16, 14, 10, 8, 7, 9, 3, 2, 4, 1)))
  }

  test("build max heap - 2 elements") {
    val arr = Array(1, 2)
    Heap.buildMaxHeap(arr)
    assert(arr.sameElements(Array(2, 1)))
  }

  test("build max heap - 2 elements - no swap") {
    val arr = Array(2, 1)
    Heap.buildMaxHeap(arr)
    assert(arr.sameElements(Array(2, 1)))
  }

  test("build max heap - 3 elements") {
    val arr = Array(1, 2, 3)
    Heap.buildMaxHeap(arr)
    assert(arr.sameElements(Array(3, 2, 1)))
  }

  test("build max heap") {
    val arr = Array(4, 1, 3, 2, 16, 9, 10, 14, 8, 7)
    Heap.buildMaxHeap(arr)
    assert(arr.sameElements(Array(16, 14, 10, 8, 7, 9, 3, 2, 4, 1)))
  }

  test("heapsort") {
    val arr = Array(4, 1, 3, 2, 16, 9, 10, 14, 8, 7)
    Heap.heapsort(arr)
    assertAscending(arr)
  }

  test("heapsort - random") {
    val arr = Seq.fill(1000)(Random.nextInt).toArray
    Heap.heapsort(arr)
    assertAscending(arr)
  }

  def assertAscending(arr: Array[Int]): Unit = {
    (0 until arr.length - 1).foreach{
      ii => assert(arr(ii) <= arr(ii+1))
    }
  }
}
