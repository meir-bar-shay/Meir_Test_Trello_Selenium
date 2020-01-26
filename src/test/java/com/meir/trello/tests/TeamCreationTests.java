package com.meir.trello.tests;

import com.meir.trello.model.TeamData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getSession().isAvatarPresentOnHeader()){
            app.getSession().logoutAtlassianAss();
        }
    }

    @Test
    public void teamCreationTestFromHeader() throws InterruptedException {

//        int countCountBefore = getTeamsCount();
        app.getBoard().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(new TeamData()
                .withTeamName("Meir1")
                .withTeamDescr("Ok!!!"));
        app.getTeam().submitTeamCreation();
//        if(isElementPresent(By.cssSelector("[name='close']"))){
//            closeInviteToTheTeamForm();
//        }
        app.getTeam().clickTeamLaterButton();
//        int TeamCountAfter = getTeamsCount();
        app.getBoard().returnToHomePage();
//        Assert.assertEquals(TeamCountAfter, countCountBefore + 1);
//        pause(10000);
    }
    @Test
    public void teamCreationTestFromHeaderWithNameOnly() throws InterruptedException {

//        int countCountBefore = getTeamsCount();
        app.getBoard().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(new TeamData()
                .withTeamName("Meir1"));
        app.getTeam().submitTeamCreation();
//        if(isElementPresent(By.cssSelector("[name='close']"))){
//            closeInviteToTheTeamForm();
//        }
        app.getTeam().clickTeamLaterButton();
//        int TeamCountAfter = getTeamsCount();
        app.getBoard().returnToHomePage();
//        Assert.assertEquals(TeamCountAfter, countCountBefore + 1);
//        pause(10000);
    }


}
