package heap.daryheap

import org.scalatest.FunSuite
import utils.TestUtils

import scala.util.Random

class HeapSortTest extends FunSuite{
  test("random, d=5") {
    val dheap = new DaryHeap(5)
    val arr = Seq.fill(10000)(Random.nextInt).toArray
    dheap.heapsort(arr)
    TestUtils.assertAscending(arr)
  }

  test("random, d=10") {
    val dheap = new DaryHeap(10)
    val arr = Seq.fill(10000)(Random.nextInt).toArray
    dheap.heapsort(arr)
    TestUtils.assertAscending(arr)
  }
}
