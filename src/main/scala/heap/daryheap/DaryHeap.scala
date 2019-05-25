package heap.daryheap

class DaryHeap (val d: Int){
  assert(d>=2)

  private[daryheap] def maxHeapify(arr: Array[Int], i: Int, heapSize: Int = -1): Unit = {
    val hs = if (heapSize < 0) arr.length else heapSize
    var largest = i
    children(i).foreach{
      c => if (c < hs && arr(c) > arr(largest)) largest = c
    }
    if (largest != i){
      swap(arr, largest, i)
      maxHeapify(arr, largest, hs)
    }
  }

  def buildMaxHeap(arr: Array[Int]): Unit = ((arr.length-2)/d to 0 by -1).foreach(maxHeapify(arr, _))

  def heapsort(arr: Array[Int]): Unit = {
    buildMaxHeap(arr)

    (arr.length - 1 until 0 by -1).foreach{
      n =>
        swap(arr, 0, n)
        maxHeapify(arr, 0, n)
    }
  }

  private def parent(i: Int): Int = {
    assert(i>0)
    (i-1)/d
  }

  private def children(i: Int): Seq[Int] = (1 to d).map(d * i + _ )

  private def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }
}
