package heap.youngtableau

object YoungTableau {
  val inf = Int.MaxValue
  private[youngtableau] def swapForward(tab: Array[Array[Int]], ij: (Int, Int)): Unit = {
    validateInputs(tab, ij)
    val i = ij._1
    val j = ij._2

    var largest_i = i
    var largest_j = j

    if (i-1 >= 0 && tab(i-1)(j) > tab(largest_i)(largest_j)) {
      largest_i = i - 1
      largest_j = j
    }

    if (j - 1 >= 0 && tab(i)(j-1) > tab(largest_i)(largest_j)) {
      largest_i = i
      largest_j = j - 1
    }

    if (largest_i != i || largest_j != j) {
      swap(tab, (i, j), (largest_i, largest_j))
      swapForward(tab, (largest_i, largest_j))
    }
  }

  private def swapBackward(tab: Array[Array[Int]], ij: (Int, Int)): Unit = {
    validateInputs(tab, ij)
    val i = ij._1
    val j = ij._2

    val M = tab.length
    val N = tab(0).length

    var largest_i = i
    var largest_j = j

    if (i+1 < M && tab(i+1)(j) < tab(largest_i)(largest_j)) {
      largest_i = i + 1
      largest_j = j
    }

    if (j + 1 < N && tab(i)(j+1) < tab(largest_i)(largest_j)) {
      largest_i = i
      largest_j = j + 1
    }

    if (largest_i != i || largest_j != j) {
      swap(tab, (i, j), (largest_i, largest_j))
      swapBackward(tab, (largest_i, largest_j))
    }
  }

  def tableaulize(tab: Array[Array[Int]]):Unit = {
    val M = tab.length
    val N = tab(0).length

    for {
      i <- 0 until M
      j <- 0 until N
    } {
      swapForward(tab, (i, j))
    }
  }

  private def validateInputs(tab: Array[Array[Int]], ij: (Int, Int)):Unit = {
    // tab contains at least one element.
    assert(tab.length>0)
    tab.forall(_.length == tab(0).length)

    val i = ij._1
    val j = ij._2

    // i and j are positive
    assert(i>=0 && j>=0)

    assert(i<tab.length)

    assert(j<tab(0).length)
  }

  private def swap(tab: Array[Array[Int]], ij1: (Int, Int), ij2: (Int, Int)): Unit = {
    val temp = tab(ij1._1)(ij1._2)
    tab(ij1._1)(ij1._2) = tab(ij2._1)(ij2._2)
    tab(ij2._1)(ij2._2) = temp
  }

  def isYoungTableau(tab: Array[Array[Int]]): Boolean = {
    val M = tab.length
    val N = tab(0).length
    for {
      i <- 0 until M
      j <- 0 until N
    } {
      if (j+1 < N && tab(i)(j) > tab(i)(j+1))
        return false
      if (i+1 < M && tab(i)(j) > tab(i+1)(j))
        return false
    }
    true
  }

  def extractMin(tab: Array[Array[Int]]): Int = {
    val out = tab(0)(0)
    tab(0)(0) = inf
    swapBackward(tab, (0, 0))
    out
  }
}
