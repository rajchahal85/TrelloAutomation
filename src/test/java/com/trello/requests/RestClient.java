package com.trello.requests;

import com.trello.specs.SpecificationFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestClient {
    public Response doPostRequest(String basePath, String resourcePath, Map<String, String> queryParams,Map<String, String> pathParams)
    {
        RestAssured.basePath = basePath;
        Response response = given()
                                .contentType(ContentType.JSON)
                                .queryParams(queryParams)
                                .spec(SpecificationFactory.logPayloadResponseInfo())
                            .when()
                                .post()
                            .then()
                                .extract()
                                .response();

        return response;
    }

    public Response doGetRequest(String basePath, String resourcePath, Map<String, String> queryParams, Map<String, String> pathParams)
    {
        Response response = given()
                                .basePath(basePath)
                                .queryParams(queryParams)
                                .pathParams(pathParams)
                                .spec(SpecificationFactory.logPayloadResponseInfo())
                                .contentType(ContentType.JSON)
                            .when()
                                .get(resourcePath)
                            .then()
                                .extract()
                                .response();
        return response;
    }

    public Response doDeleteRequest(String basePath, String resourcePath, Map<String, String> queryParams,Map<String, String> pathParams)
    {
        RestAssured.basePath = basePath;
        Response response = given()
                                .contentType(ContentType.JSON)
                                .queryParams(queryParams)
                                .pathParams(pathParams)
                                .spec(SpecificationFactory.logPayloadResponseInfo())
                            .when()
                                .delete(resourcePath)
                            .then()
                                .extract()
                                .response();

        return response;
    }
}
