package requests

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object PostNewBasket {
  val post: ChainBuilder = exec(
    http(requestName = "Post New Basket")
      .post(url = "/basket")
      .header("content-type","application/json")
      .body(StringBody("${basket}")).asJson
  )
}
