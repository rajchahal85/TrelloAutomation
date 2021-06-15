package com.trello.tests;

import com.trello.requests.RequestFactory;
import com.trello.specs.SpecificationFactory;
import org.testng.annotations.Test;


public class TrelloTests extends TestBase {
    RequestFactory requests = new RequestFactory();

    @Test(description = "Create a new Board")
    public void createBoardTest()
    {
        String boardId = requests.createBoard("test Board 123")
                            .then()
                                .spec(SpecificationFactory.getGenericResponseSpec())
                                .extract().response()
                                .jsonPath().getString("id");

        requests.getBoardDetails(boardId);
        Actions.deleteBoard(boardId);
    }

    @Test(description = "Get Board Details")
    public void getBoardDetailsTest()
    {
        String boardId = Actions.createBoard();
        requests.getBoardDetails(boardId);
        Actions.deleteBoard(boardId);
    }



    @Test(description = "Create a new List")
    public void createListToDo()
    {
        String boardId = Actions.createBoard();
        String listId = Actions.createList(boardId);
        Actions.deleteBoard(boardId);
    }





    @Test(description = "Create a new Card")
    public void createCardTest()
    {
        String boardId = Actions.createBoard();
        String listIdToDo = Actions.createList(boardId, "List ToDo");
        String cardId = Actions.createCard(listIdToDo, "Card Test", "Card Name Description");
        Actions.deleteBoard(boardId);
    }



    @Test(description = "Move a Card")
    public void moveCardTest()
    {
        String boardId = Actions.createBoard();
        String listIdToDo = Actions.createList(boardId, "List to Do");
        String listIdDone = Actions.createList(boardId, "List Done");

        String cardId = Actions.createCard(listIdToDo, "Card Name", "Test Card Description");
        Actions.moveCard(cardId, listIdDone);
        Actions.deleteBoard(boardId);

    }



    @Test(description = "Delete a board")
    public void deleteBoardTest()
    {
        String boardId = Actions.createBoard();
        Actions.deleteBoard(boardId);
    }




}
