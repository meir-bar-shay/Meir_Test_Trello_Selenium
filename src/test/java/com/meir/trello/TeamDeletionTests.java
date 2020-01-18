package com.meir.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            logoutAtlassianAss();
        }
    }


    @Test
    public void deletionBoardTests() throws InterruptedException {
//        int countCountBefore = getTeamsCount();
        clickOnTheTeam();
        clickOnTeamSettings();
        clickOnDeleteTeamButton();
        submitDeletion();
//        int TeamCountAfter = getTeamsCount();
//        Assert.assertEquals(TeamCountAfter, countCountBefore - 1);
    }


}
