package com.meir.trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!isAvatarPresentOnHeader()){
            logoutAtlassianAss();
        }
    }
    @Test
    public void CreateBoard() throws InterruptedException {
        final int NUMBER_OF_BOARDS = 3; // number of boards to create
        int before = getBoardsCount();
        System.out.println("actualRes = " + before);

        for(int i = 0; i < NUMBER_OF_BOARDS; i++) {
            clickOnPlusButton();
            selectCreateBoardFromDropDown();
            fillBoardForm("QA_22" + System.currentTimeMillis());
            confirmBoardCreation();
            pause(5000);
            returnToHomePage();
            pause(5000);
        }
        int actualRes = getBoardsCount();
        int expectedRes = before + NUMBER_OF_BOARDS;
        pause(5000);
        //Assert.assertEquals(actualRes,expectedRes);
        System.out.println("actualRes = " + actualRes);
        System.out.println("expectedRes = " + expectedRes);
    }

}