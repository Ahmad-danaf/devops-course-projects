package simulations;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;
import io.gatling.javaapi.http.HttpProtocolBuilder;

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
                constantUsersPerSec(5).during(Duration.ofMinutes(5)) // 5 minutes
            )
        ).protocols(httpProtocol);
    }
}
