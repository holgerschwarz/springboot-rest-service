package de.holger.city;


import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("TEST_STUB")
public class ControllerTest {

    @LocalServerPort
    private Integer serverport;

    @Before
    public void setup() {
        RestAssured.port = serverport;
    }


    @Test
    public void restCitiesMitStatusCode200Zurueckgeben() {
        when().get("/v1/cities").then().statusCode(200);
    }

    @Test
    public void restCitiesMitStadnameMitStatusCode202Zurueckgeben() {
        when().get("/v1/cities/xyzTest").then().statusCode(404);
    }

    @Test
    public void restCitiesMitStadnameMitStatusCode200Zurueckgeben() {
        when().get("/v1/cities/abcTest").then().statusCode(200);
    }

}