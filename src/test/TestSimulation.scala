import generators.BasketGenerator
import io.gatling.core.Predef._

import scala.concurrent.duration._
import utils.Constants
import requests.PostNewBasket

class TestSimulation extends Simulation {
  private val casualCustomer = Iterator.continually(Map("basket" -> BasketGenerator.casual))
  private val bigSpender = Iterator.continually(Map("basket" -> BasketGenerator.bigSpender))

  private val casualCustomerScenario = scenario(scenarioName = "Casual customer")
    .feed(casualCustomer)
    .exec(PostNewBasket.post)
    /* Example how to print Gatling session variables for debugging:
    *
    *.exec { session=>
    *  println(session("basket").as[String])
    *  session
    */
    }

  private val bigSpenderScenario = scenario(scenarioName = "Big spender")
    .feed(bigSpender)
    .exec(PostNewBasket.post)

  setUp(
    casualCustomerScenario.inject(
      constantUsersPerSec(1) during (1 second)
      /* Example load scenario with ramp up/down:
      *
      * rampUsersPerSec(0) to 20 during (30 minutes),
      * constantUsersPerSec(20) during (3 hours),
      * rampUsersPerSec(20) to 0 during (30 minutes)
      */
    ),
    bigSpenderScenario.inject(
      constantUsersPerSec(1) during (1 second)
    //  constantUsersPerSec(0.1) during (4 hours)
    )
  ).protocols(Constants.httpProtocol)


}
