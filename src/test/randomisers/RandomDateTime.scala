package randomisers

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit.DAYS

import scala.util.Random

object RandomDateTime {
  def apply(minusDaysFrom : Int, minusDaysTo : Int): String ={
    val from = ZonedDateTime.now().minusDays(minusDaysFrom)
    val to = ZonedDateTime.now().minusDays(minusDaysTo)
    val diff = DAYS.between(from, to)
    val random = new Random(System.nanoTime)
    val randomDateTime = from.plusDays(random.nextInt(diff.toInt))
    val formattedDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(randomDateTime)
    formattedDateTime
  }
}
