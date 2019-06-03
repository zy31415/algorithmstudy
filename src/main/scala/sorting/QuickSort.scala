package sorting

object QuickSort {
  /*
  Functional implementation of quicksort.
   */
  def fsort(arr: List[Int]): List[Int] =
    arr match {
      case a if a.length <= 1 => a
      case pivot :: rest =>
        val (before, after) = rest.partition(_<=pivot)
        fsort(before) ::: (pivot :: fsort(after))
    }
}
