package heap.daryheap

import org.scalatest.FunSuite

class MaxHeapifyTest extends FunSuite {
  test("test, d=2, length=1") {
    val dheap = new DaryHeap(2)
    val arr = Array(1)
    dheap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(1)))
  }

  test("test, d=3, length=1") {
    val dheap = new DaryHeap(3)
    val arr = Array(1)
    dheap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(1)))
  }

  test("test, d=2, length=2") {
    val dheap = new DaryHeap(2)
    val arr = Array(1, 2)
    dheap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(2, 1)))
  }

  test("test, d=3, length=2") {
    val dheap = new DaryHeap(3)
    val arr = Array(1, 2)
    dheap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(2, 1)))
  }

  test("test, d=2, length=3") {
    val dheap = new DaryHeap(2)
    val arr = Array(1, 2, 3)
    dheap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(3, 2, 1)))
  }

  test("test, d=3, length=3") {
    val dheap = new DaryHeap(3)
    val arr = Array(1, 2, 3)
    dheap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(3, 2, 1)))
  }

  test("test, d=2, length=4") {
    val dheap = new DaryHeap(2)
    val arr = Array(1, 4, 2, 3)
    dheap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(4, 3, 2, 1)))
  }

  test("test, d=3, length=4") {
    val dheap = new DaryHeap(3)
    val arr = Array(1, 4, 2, 3)
    dheap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(4, 1, 2, 3)))
  }

  test("test, d=2, length=5") {
    val dheap = new DaryHeap(2)
    val arr = Array(1, 5, 2, 3, 4)
    dheap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(5, 4, 2, 3, 1)))
  }

  test("test, d=3, length=5") {
    val dheap = new DaryHeap(3)
    val arr = Array(1, 5, 2, 3, 4)
    dheap.maxHeapify(arr, 0)
    assert(arr.sameElements(Array(5, 4, 2, 3, 1)))
  }
}
