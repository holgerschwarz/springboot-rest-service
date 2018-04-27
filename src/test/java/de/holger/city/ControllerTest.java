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
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

@LocalServerPort
private Integer serverport;

    @Before
    public  void setup() {
         RestAssured.port = serverport;
    }


    @Test
    public void citiesMitStatusCode200Zurueckgeben() {
        when().get("/v1/cities").then().statusCode(200);
    }



}