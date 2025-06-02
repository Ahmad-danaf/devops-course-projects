package simulations;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class LoadSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
        .baseUrl("http://localhost:8080/adam_ahmad/")
        .acceptHeader("text/html")
        .disableCaching();

    ScenarioBuilder scn = scenario("Load Test")
        .repeat(100).on(
            exec(http("Load Request")
                .get("/index.jsp")
                .check(status().is(200))
            )
        );

    {
        setUp(
            scn.injectOpen(
                constantUsersPerSec(1).during(30)
            )
        ).protocols(httpProtocol);
    }
}
