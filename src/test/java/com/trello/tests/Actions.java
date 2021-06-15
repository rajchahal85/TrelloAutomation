package com.trello.tests;

import com.trello.requests.RequestFactory;
import com.trello.specs.SpecificationFactory;
import io.restassured.response.Response;

public class Actions {
    private static RequestFactory requestFactory = new RequestFactory();

    public static String createBoard(String boardName)
    {
        return requestFactory.createBoard(boardName)
                .then()
                .spec(SpecificationFactory.getGenericResponseSpec())
                .extract().response()
                .jsonPath().getString("id");
    }

    public static String createBoard()
    {
        return createBoard("Random Test Card");
    }

    public static String createList(String boardId)
    {

        return createList(boardId, "Test List ToDo");
    }

    public static String createList(String boardId, String listName)
    {
        return requestFactory.createList(boardId, listName)
                .then()
                .spec(SpecificationFactory.getGenericResponseSpec())
                .extract().response()
                .jsonPath().getString("id");
    }

    public static boolean deleteBoard(String boardId) {
        requestFactory.deleteBoard(boardId)
                                .then()
                                    .spec(SpecificationFactory.getGenericResponseSpec())
                                    .extract().response();

        return true;
    }

    public static String createCard(String idList, String cardName, String cardDescription) {
        return requestFactory.createCard(idList, cardName, cardDescription)
                .then()
                    .spec(SpecificationFactory.getGenericResponseSpec())
                    .extract().response()
                    .jsonPath().getString("id");
    }

    public static boolean moveCard(String cardId, String listIdDone) {
        requestFactory.moveCard(cardId, listIdDone)
                                .then()
                                .spec(SpecificationFactory.getGenericResponseSpec())
                                .extract().response();
        return true;
    }
}
