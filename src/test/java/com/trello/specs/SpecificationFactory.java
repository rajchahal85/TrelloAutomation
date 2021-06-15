package com.trello.specs;

import com.trello.tests.TestBase;
import com.trello.util.PropertyReader;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationFactory extends TestBase {
    public static synchronized ResponseSpecification getGenericResponseSpec() {
        ResponseSpecBuilder responseSpec;
        ResponseSpecification responseSpecification;
        responseSpec = new ResponseSpecBuilder();
        responseSpec.expectStatusCode(200);

        responseSpecification = responseSpec.build();

        return responseSpecification;
    }

    public static synchronized RequestSpecification logPayloadResponseInfo() {
        RequestSpecBuilder logBuilder;
        RequestSpecification logSpecification;

        logBuilder = new RequestSpecBuilder();
        logBuilder.addFilter(new AllureRestAssured());
        logBuilder.addQueryParam("key", PropertyReader.getInstance().getProperty("key"));
        logBuilder.addQueryParam("token", PropertyReader.getInstance().getProperty("token"));
        logSpecification = logBuilder.build();
        return logSpecification;
    }
}
