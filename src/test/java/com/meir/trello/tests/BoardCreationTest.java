package com.meir.trello.tests;

import com.meir.trello.model.BoardData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.getSession().isAvatarPresentOnHeader()){
            app.getSession().logoutAtlassianAss();
        }
    }
    @Test
    public void CreateBoard() throws InterruptedException {
        final int NUMBER_OF_BOARDS = 3; // number of boards to create
        int before = app.getBoard().getBoardsCount();
        System.out.println("actualRes = " + before);

        for(int i = 0; i < NUMBER_OF_BOARDS; i++) {
            app.getBoard().clickOnPlusButton();
            app.getBoard().selectCreateBoardFromDropDown();
            app.getBoard().fillBoardForm(new BoardData()
                    .setBoardName("QA_22" + System.currentTimeMillis()));
            app.getBoard().confirmBoardCreation();
            app.getBoard().pause(5000);
            app.getBoard().returnToHomePage();
            app.getBoard().pause(5000);
        }
        int actualRes = app.getBoard().getBoardsCount();
        int expectedRes = before + NUMBER_OF_BOARDS;
        app.getBoard().pause(5000);
        //Assert.assertEquals(actualRes,expectedRes);
        System.out.println("actualRes = " + actualRes);
        System.out.println("expectedRes = " + expectedRes);
    }

}