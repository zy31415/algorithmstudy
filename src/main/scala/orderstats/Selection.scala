package orderstats


object Selection {
  def select(arr: Array[Int], m: Int): Int = {
    select(arr, 0, arr.length - 1, m)
  }

  private def select(arr: Array[Int], from: Int, end: Int, m: Int): Int = {
    assert(from >= 0 && from < arr.length)
    assert(end >= 0 && end < arr.length)
    assert(end >= from)
    assert(m >= 0 && m <= end - from)

    val d = partition(arr, from, end)

    val lower_size = d - from

    if (lower_size == m)
      return arr(d)

    if (m < lower_size)
      return select(arr, from, d - 1, m)

    select(arr, d+1, end, m - lower_size - 1)
  }

  // Guarantee a good partition
  private def partition(arr: Array[Int], from: Int, end: Int): Int = {
    val p = findPivot(arr, (from to end).toArray)
    swap(arr, p, end)

    val r = arr(end)
    var q = from

    for(i <- from until end) {
      if (arr(i) < r) {
        swap(arr, q, i)
        q = q + 1
      }
    }
    swap(arr, q, end)
    q
  }

  private def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }

  private def findPivot(arr: Array[Int], indices: Array[Int]): Int = medianOfMedians(arr, indices)

  private def medianOfMedians(arr: Array[Int], indices: Array[Int]): Int =
    if (indices.length == 1)
      indices(0)
    else
      medianOfMedians(arr, indices.grouped(5).map(medianOfFive(arr, _)).toArray)

  private def medianOfFive(arr: Array[Int], indices: Array[Int]): Int = {
    assert(indices.length <= 5)

    for (p <- 1 until indices.length) {
      var v = arr(indices(p))
      for(q <- 0 until p) {
        val cur = arr(indices(q))
        if (v < cur) {
          arr(indices(q)) = v
          v = cur
        }
      }
      arr(indices(p)) = v
    }

    indices(indices.length/2)
  }
}
