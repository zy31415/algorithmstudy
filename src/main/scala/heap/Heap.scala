package heap

object Heap {
  private[heap] def maxHeapify(arr: Array[Int], i: Int, heapsize: Int = -1): Unit = {

    val hp = if (heapsize >= 0 ) heapsize else arr.length

    val l = leftChildIndex(i)
    val r = rightChildIndex(i)
    var largest = i
    if (l < hp && arr(l) > arr(largest))
      largest = l
    if (r < hp && arr(r) > arr(largest))
      largest = r

    if (i != largest) {
      swap(arr, largest, i)
      maxHeapify(arr, largest, hp)
    }
  }

  def buildMaxHeap(arr: Array[Int], heapSize: Int = -1): Unit = {
    val hs = if (heapSize >= 0) heapSize else arr.length
    ((hs/2 - 1) to 0 by -1).foreach(maxHeapify(arr, _))
  }

  def heapsort(arr: Array[Int]): Unit = {
    buildMaxHeap(arr)

    (arr.length - 1 until 0 by -1).foreach {
      ii =>
        swap(arr, 0, ii)
        maxHeapify(arr, 0, ii)
    }
  }

  private def leftChildIndex(i: Int): Int = 2 * i + 1
  private def rightChildIndex(i: Int): Int = (i + 1) * 2

  private def swap(arr: Array[Int], i: Int, j: Int) = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }
}

