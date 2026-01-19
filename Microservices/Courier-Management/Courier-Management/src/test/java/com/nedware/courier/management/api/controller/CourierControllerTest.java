package com.nedware.courier.management.api.controller;

import com.nedware.courier.management.domain.model.Courier;
import com.nedware.courier.management.domain.repository.CourierRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CourierControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private CourierRepository courierRepository;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
        RestAssured.basePath = "/api/v1/couriers";
    }

    @Test
    public void shouldReturn201() {
        String requestBody = """
                {
                    "name": "João da Silva",
                    "phone": "11999999999"
                }
                """;
        RestAssured
            .given()
                .body(requestBody)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
            .when()
                .post()
            .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo("João da Silva"));

    }

    @Test
    void shouldReturn200() {
        UUID CourierId = courierRepository.saveAndFlush(
                Courier.brandNew(
                        "Maria de Souza",
                        "21988888888"
                )
        ).getId();

        RestAssured
            .given()
                .pathParam("courierId", CourierId)
                .accept(ContentType.JSON)
            .when()
                .get("/{courierId}")
            .then()
                .statusCode(HttpStatus.OK.value())
                .body("id", Matchers.equalTo(CourierId.toString()))
                .body("name", Matchers.equalTo("Maria de Souza"));
    }

}