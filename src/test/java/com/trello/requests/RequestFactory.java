package com.trello.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class RequestFactory {
    RestClient restClient = new RestClient();

    @Step("Create Board : {0}")
    public Response createBoard(String boardName)
    {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", boardName);

        return restClient.doPostRequest("1/boards", "1/boards", queryParams, null);
    }



    @Step("Get Board Details : {0}")
    public Response getBoardDetails(String boardId)
    {
        Map<String, String> queryParams = new HashMap<>();

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("boardId", boardId);

        return restClient.doGetRequest("/1/boards", "/{boardId}", queryParams, pathParams);
    }

    @Step("Create List : {1} under Board : {0}")
    public Response createList(String boardId, String listName)
    {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", listName);
        queryParams.put("idBoard", boardId);


        return restClient.doPostRequest("1/lists", "", queryParams, null);
    }


    @Step("Move Card : {0} to List : {1}")
    public Response moveCard(String cardId, String targetList)
    {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("idList", targetList);

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("cardId", cardId);

        return restClient.doPostRequest("1/cards", "/{cardId}", queryParams, pathParams);
    }

    @Step("Delete Board : {0}")
    public Response deleteBoard(String boardId)
    {
        Map<String, String> queryParams = new HashMap<>();
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("id", boardId);

        return restClient.doDeleteRequest("/1/boards", "/{id}", queryParams, pathParams);
    }

    @Step("Create Card")
    public Response createCard(String idList, String cardName, String cardDescription) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", cardName);
        queryParams.put("desc", cardDescription);
        queryParams.put("idList", idList);

        Map<String, String> pathParams = new HashMap<>();

        return restClient.doPostRequest("1/cards", "", queryParams, pathParams);
    }
}
