package com.meir.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.isAvatarPresentOnHeader()){
            app.logoutAtlassianAss();
        }
    }
    @Test
    public void CreateBoard() throws InterruptedException {
        final int NUMBER_OF_BOARDS = 3; // number of boards to create
        int before = app.getBoardHelper().getBoardsCount();
        System.out.println("actualRes = " + before);

        for(int i = 0; i < NUMBER_OF_BOARDS; i++) {
            app.getBoardHelper().clickOnPlusButton();
            app.getBoardHelper().selectCreateBoardFromDropDown();
            app.getBoardHelper().fillBoardForm("QA_22" + System.currentTimeMillis());
            app.getBoardHelper().confirmBoardCreation();
            app.getBoardHelper().pause(5000);
            app.getBoardHelper().returnToHomePage();
            app.getBoardHelper().pause(5000);
        }
        int actualRes = app.getBoardHelper().getBoardsCount();
        int expectedRes = before + NUMBER_OF_BOARDS;
        app.pause(5000);
        //Assert.assertEquals(actualRes,expectedRes);
        System.out.println("actualRes = " + actualRes);
        System.out.println("expectedRes = " + expectedRes);
    }

}