package orderstats


object RandomisedSelection {

  private var _seed: Option[Int] = None

  def select(arr: Array[Int], m: Int): Int = {
    select(arr, 0, arr.length - 1, m)
  }

  private def select(arr: Array[Int], from: Int, end: Int, m: Int): Int = {
    assert(from >= 0 && from < arr.length)
    assert(end >= 0 && end < arr.length)
    assert(end >= from)
    assert(m >= 0 && m <= end - from)

    val d = randomizedPartition(arr, from, end)

    val lower_size = d - from

    if (lower_size == m)
      return arr(d)

    if (m < lower_size)
      return select(arr, from, d - 1, m)

    select(arr, d+1, end, m - lower_size - 1)
  }

  private def random(start: Int, end: Int): Int = {
    val rnd = new scala.util.Random(_seed.getOrElse(System.currentTimeMillis.toInt))
    start + rnd.nextInt( (end - start) + 1 )
  }

  private def randomizedPartition(arr: Array[Int], from: Int, end: Int): Int = {
    val p= random(from, end)
    swap(arr, end, p)
    partition(arr, from, end)
  }

  private def partition(arr: Array[Int], from: Int, end:Int): Int = {
    var q = from
    val v = arr(end)
    for(i <- from until end) {
      if (arr(i) < v) {
        swap(arr, q, i)
        q += 1
      }
    }
    swap(arr, q, end)
    q
  }

  private def swap(arr: Array[Int], ii: Int, jj: Int):Unit = {
    val temp = arr(ii)
    arr(ii) = arr(jj)
    arr(jj) = temp
  }

  def seed:Int = _seed.getOrElse(System.currentTimeMillis.toInt)
  def seed_= (v: Int) {_seed = Some(v)}
}
