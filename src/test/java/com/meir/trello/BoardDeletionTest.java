package com.meir.trello;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!isAvatarPresentOnHeader()){
            logoutAtlassianAss();
        }
    }
    @Test
    public void deleteSingleBoardTest() throws InterruptedException {
        if(boardIsSuccessfullyClicked())
            boardDeletionProcess();

    }
    @Test
    public void deleteAllBoardsTest() throws InterruptedException {

        while(boardIsSuccessfullyClicked())
        {
            boardDeletionProcess();
        }
    }


    public void boardDeletionProcess() throws InterruptedException {
        openMoreBoard();
        selectCloseBoardButton();
        clickButtonCloseBoard();
        permanentlyBoard();
        permanentlyDeleteBoard();
        returnToHomePage();
        pause(5000);
    }

}