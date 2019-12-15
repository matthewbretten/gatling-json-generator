package randomisers

import java.util.Locale
import scala.util.Random

object RandomISOCountryCode {
  def generate: String = {
    val countryCodeList: Iterator[String] = Locale.getISOCountries.toIterator
    val shuffledCountryCodeList = Random.shuffle(countryCodeList)
    val randomCountryCode = shuffledCountryCodeList.next
    val locale: Locale = new Locale("", randomCountryCode)
    locale.getCountry
  }
}