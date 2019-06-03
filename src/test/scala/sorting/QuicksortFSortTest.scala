package sorting

import org.scalatest.FunSuite
import utils.TestUtils

import scala.util.Random

class QuicksortFSortTest extends FunSuite {

  test ("test 3 elements") {
    val sorted = QuickSort.fsort(List(3,1,2))
    sorted.foreach(println(_))
  }


  test ("test random") {
    val arr = List.fill(100)(Random.nextInt(1000))
    val sorted = QuickSort.fsort(arr)
    TestUtils.assertAscending(sorted)
  }
}
