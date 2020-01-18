package com.meir.trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!isAvatarPresentOnHeader()){
            logoutAtlassianAss();
        }
    }

    @Test
    public void teamCreationTestFromHeader() throws InterruptedException {

//        int countCountBefore = getTeamsCount();
        clickOnPlusButton();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("Meir1", "Ok!!!");
        submitTeamCreation();
//        if(isElementPresent(By.cssSelector("[name='close']"))){
//            closeInviteToTheTeamForm();
//        }
        clickTeamLaterButton();
//        int TeamCountAfter = getTeamsCount();
        returnToHomePage();
//        Assert.assertEquals(TeamCountAfter, countCountBefore + 1);
//        pause(10000);
    }

}
