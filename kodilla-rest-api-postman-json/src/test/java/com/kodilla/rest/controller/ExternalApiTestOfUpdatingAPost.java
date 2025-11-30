package com.kodilla.rest.controller;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class ExternalApiTestOfUpdatingAPost {

    @Test
    void shouldUpdatePost() {

        Map<String, Object> updatedPostData = new HashMap<>();
        updatedPostData.put("id", 1);
        updatedPostData.put("title", "Updated title");
        updatedPostData.put("body", "Updated body text for the post.");
        updatedPostData.put("userId", 1);

        given().
                header("Content-Type", "application/json").
                body(updatedPostData).
        when().
                put("https://jsonplaceholder.typicode.com/posts/1").
        then().
                statusCode(200).
                body("id", equalTo(1)).
                body("title", equalTo("Updated title")).
                body("body", equalTo("Updated body text for the post.")).
                body("userId", equalTo(1)).
                log().all();
    }

}