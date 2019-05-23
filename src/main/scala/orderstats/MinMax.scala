package orderstats

object MinMax {
  def minMax(arr: Seq[Int]): (Int, Int) = {
    var min = Int.MaxValue
    var max = Int.MinValue

    arr.foreach{
      a =>
        if (a < min)
          min = a
        if (a > max)
          max = a
    }
    (min, max)
  }

  def minMax2(arr: Seq[Int]): (Int, Int) = {
    var min = Int.MaxValue
    var max = Int.MinValue
    var n = 0

    val _arr = if (arr.length % 2 == 1) arr :+ arr.last else arr

    _arr.grouped(2).foreach{
      pair =>
        val (a1, a2) = (pair.head, pair.last)
        val (_max, _min) = if (a1 > a2) (a1, a2) else (a2, a1)

        if (_max > max)
          max = _max

        if (_min < min)
          min = _min
    }
    (min, max)
  }
}
