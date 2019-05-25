package heap.daryheap

import org.scalatest.FunSuite

class BuildMaxHeapTest extends FunSuite {
  test("d=2, length=2") {
    val dheap = new DaryHeap(2)
    val arr = Array(1, 2)
    dheap.buildMaxHeap(arr)
    assert(arr.sameElements(Array(2, 1)))
  }

  test("d=3, length=2") {
    val dheap = new DaryHeap(3)
    val arr = Array(1, 2)
    dheap.buildMaxHeap(arr)
    assert(arr.sameElements(Array(2, 1)))
  }

  test("d=2, length=3") {
    val dheap = new DaryHeap(2)
    val arr = Array(1, 2, 3)
    dheap.buildMaxHeap(arr)
    assert(arr.sameElements(Array(3, 2, 1)))
  }

  test("d=3, length=3") {
    val dheap = new DaryHeap(3)
    val arr = Array(1, 2, 3)
    dheap.buildMaxHeap(arr)
    assert(arr.sameElements(Array(3, 2, 1)))
  }

  test("d=2, length=4") {
    val dheap = new DaryHeap(2)
    val arr = Array(1, 2, 3, 4)
    dheap.buildMaxHeap(arr)
    assert(arr.sameElements(Array(4, 2, 3, 1)))
  }

  test("d=3, length=4") {
    val dheap = new DaryHeap(3)
    val arr = Array(1, 2, 3, 4)
    dheap.buildMaxHeap(arr)
    assert(arr.sameElements(Array(4, 2, 3, 1)))
  }

  test("d=2, length=5") {
    val dheap = new DaryHeap(2)
    val arr = Array(1, 2, 3, 4, 5)
    dheap.buildMaxHeap(arr)
    assert(arr.sameElements(Array(5, 4, 3, 1, 2)))
  }

  test("d=3, length=5") {
    val dheap = new DaryHeap(3)
    val arr = Array(1, 2, 3, 4, 5)
    dheap.buildMaxHeap(arr)
    assert(arr.sameElements(Array(5, 2, 3, 4, 1)))
  }
}
