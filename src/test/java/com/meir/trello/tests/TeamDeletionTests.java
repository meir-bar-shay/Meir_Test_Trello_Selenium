package com.meir.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().logoutAtlassianAss();
        }
    }


    @Test
    public void deletionBoardTests() throws InterruptedException {
//        int countCountBefore = getTeamsCount();
        app.getTeam().clickOnTheTeam();
        app.getTeam().clickOnTeamSettings();
        app.getTeam().clickOnDeleteTeamButton();
        app.getTeam().submitDeletion();
//        int TeamCountAfter = getTeamsCount();
//        Assert.assertEquals(TeamCountAfter, countCountBefore - 1);
    }


}
