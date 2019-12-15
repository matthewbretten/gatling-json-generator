package randomisers

import scala.annotation.tailrec
import scala.util.Random

object RandomIntBetween{
  def apply(minInclusive : Int, maxExclusive : Int): Int = {
    require(minInclusive < maxExclusive, "Invalid bounds")

    val difference = maxExclusive - minInclusive
    if (difference >= 0) {
      Random.nextInt(difference) + minInclusive
    } else {
      /* The interval size here is greater than Int.MaxValue,
       * so the Loop will exit with a probability of at least 1/2.
       */
      @tailrec
      def loop(): Int = {
        val n = Random.nextInt()
        if (n >= minInclusive && n < maxExclusive) n
        else loop()
      }
      loop()
    }
  }
}
