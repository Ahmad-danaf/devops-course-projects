package simulations;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class MaxLoadTest extends Simulation {

    HttpProtocolBuilder httpProtocol = http
        .baseUrl("http://localhost:8080/adam_ahmad")
        .acceptHeader("text/html")
        .disableCaching();

    ScenarioBuilder scn = scenario("Max Load Test")
        .exec(
            http("Max Load Request")
                .get("/index.jsp")
                .check(status().is(200))
        );

    {
        setUp(
            scn.injectOpen(
                rampUsers(400).during(30)
            )
        ).protocols(httpProtocol);
    }
}
