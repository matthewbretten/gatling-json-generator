package generators

import io.circe.Json
import io.circe.generic.auto._
import io.circe.syntax._
import objects.Basket
import randomisers.{RandomDateTime, RandomIntBetween}

object BasketGenerator{
  def basket(numberOfItems: Int = RandomIntBetween(minInclusive = 1, maxExclusive = 5)): Json = {
    val items = ItemsGenerator.itemsList(numberOfItems = numberOfItems)
    val totalPrice = ItemsGenerator.totalPrice
    Basket(
      customer = CustomerGenerator.customer,
      items = items,
      totalPrice = totalPrice,
      dateCreated = RandomDateTime(minusDaysFrom = 30, minusDaysTo = 1)
    ).asJson
  }

  def casual: Json = basket()

  def bigSpender : Json = basket(numberOfItems = RandomIntBetween(minInclusive = 5, maxExclusive = 10))
}