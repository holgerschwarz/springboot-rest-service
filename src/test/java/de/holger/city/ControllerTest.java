package de.holger.city;


import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan("de.holger.city.services.ServicesCitiesStub")
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
        when().get("/v1/cities/essen").then().statusCode(202);
    }

    @Test
    public void restCitiesMitStadnameMitStatusCode200Zurueckgeben() {
        when().get("/v1/cities/Langenfeld").then().statusCode(200);
    }

}