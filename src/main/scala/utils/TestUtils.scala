package utils

object TestUtils {
  def assertAscending[T:Ordering](arr: Seq[T]): Unit = {
    val ord = implicitly[Ordering[T]]
    (0 until arr.length - 1).foreach{
      ii => assert(ord.lteq(arr(ii),arr(ii+1)))
    }
  }
}
