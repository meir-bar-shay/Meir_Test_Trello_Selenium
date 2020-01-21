package com.meir.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.isAvatarPresentOnHeader()){
            app.logoutAtlassianAss();
        }
    }

    @Test
    public void teamCreationTestFromHeader() throws InterruptedException {

//        int countCountBefore = getTeamsCount();
        app.getBoardHelper().clickOnPlusButton();
        app.selectCreateTeamFromDropDown();
        app.fillTeamCreationForm("Meir1", "Ok!!!");
        app.submitTeamCreation();
//        if(isElementPresent(By.cssSelector("[name='close']"))){
//            closeInviteToTheTeamForm();
//        }
        app.clickTeamLaterButton();
//        int TeamCountAfter = getTeamsCount();
        app.returnToHomePage();
//        Assert.assertEquals(TeamCountAfter, countCountBefore + 1);
//        pause(10000);
    }

}
