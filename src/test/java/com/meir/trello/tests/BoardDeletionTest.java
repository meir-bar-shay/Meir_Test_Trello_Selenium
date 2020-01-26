package com.meir.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.getSession().isAvatarPresentOnHeader()){
            app.getSession().logoutAtlassianAss();
        }
    }
    @Test
    public void deleteSingleBoardTest() throws InterruptedException {
        if(app.getBoard().boardIsSuccessfullyClicked())
            app.getBoard().boardDeletionProcess();

    }
    @Test
    public void deleteAllBoardsTest() throws InterruptedException {

        while(app.getBoard().boardIsSuccessfullyClicked())
        {
            app.getBoard().boardDeletionProcess();
        }
    }


}