package lcs

class LCSFinder(val s1: String, val s2: String) {

  def search(): Seq[String]= {
    get(0, 0)
  }

  private def get(n1: Int, n2: Int): Seq[String] = {
    var l1 = s1.length - 1
    var l2 = s2.length - 1

    if (n1 > l1 || n2 > l2)
      return Seq("")

    var lcs = Seq("")
    var m = lcs.head.length

    for (i1 <- n1 to l1) {
      var i2 = n2
      val c = s1(i1)
      while (i2 <= l2) {
        if ( c == s2(i2)){
          val subs = get(i1+1, i2+1)
          if (subs.head.length >= m - 1) {
            if (subs.head.length > m - 1)
              lcs = Seq()
            for(s <- subs)
              lcs = lcs :+ (c + s)
            m = lcs.head.length
          }
        }
        i2 += 1
      }
    }
    lcs
  }
}
