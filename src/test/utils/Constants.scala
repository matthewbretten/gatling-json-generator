package utils

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

object Constants {

  private val baseUrl = "http://localhost:5000"

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(baseUrl)
    .check(status.is(200))
}
