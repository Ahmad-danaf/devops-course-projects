package simulations;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class StressSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
        .baseUrl("http://localhost:8080/adam_ahmad/")
        .acceptHeader("text/html")
        .disableCaching();

    ScenarioBuilder scn = scenario("Stress Test")
        .exec(
            http("Stress Request")
                .get("/index.jsp")
                .check(status().is(200))
        );

    {
        setUp(
            scn.injectOpen(
                rampUsersPerSec(1).to(100).during(240) // 4 minutes in seconds
            )
        ).protocols(httpProtocol);
    }
}
