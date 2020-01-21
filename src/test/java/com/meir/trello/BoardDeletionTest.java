package com.meir.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.isAvatarPresentOnHeader()){
            app.logoutAtlassianAss();
        }
    }
    @Test
    public void deleteSingleBoardTest() throws InterruptedException {
        if(app.getBoardHelper().boardIsSuccessfullyClicked())
            app.getBoardHelper().boardDeletionProcess();

    }
    @Test
    public void deleteAllBoardsTest() throws InterruptedException {

        while(app.getBoardHelper().boardIsSuccessfullyClicked())
        {
            app.getBoardHelper().boardDeletionProcess();
        }
    }


}