package generators

import objects.Customer
import randomisers.{RandomISOCountryCode, RandomIntBetween}

import scala.util.Random

object CustomerGenerator {
 def customer: Customer = Customer(
     name = Random.alphanumeric.take(30).mkString,
     age = RandomIntBetween(minInclusive = 15, maxExclusive = 90),
     countryCode = RandomISOCountryCode.generate
   )
}
