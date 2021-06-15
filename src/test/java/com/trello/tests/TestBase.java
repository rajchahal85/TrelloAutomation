package com.trello.tests;

import com.trello.util.PropertyReader;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public static PropertyReader prop;

    @BeforeClass(description = "Initialize the baseURI for RestAssured class")
    public void initUrl()
    {
        prop = PropertyReader.getInstance();
        RestAssured.baseURI = prop.getProperty("baseUrl");
    }
}
