package com.meir.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.isAvatarPresentOnHeader()) {
            app.logoutAtlassianAss();
        }
    }


    @Test
    public void deletionBoardTests() throws InterruptedException {
//        int countCountBefore = getTeamsCount();
        app.clickOnTheTeam();
        app.clickOnTeamSettings();
        app.clickOnDeleteTeamButton();
        app.submitDeletion();
//        int TeamCountAfter = getTeamsCount();
//        Assert.assertEquals(TeamCountAfter, countCountBefore - 1);
    }


}
