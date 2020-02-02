package com.meir.trello.tests;

import com.meir.trello.model.TeamData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.graalvm.compiler.nodes.PauseNode.pause;

public class TeamCreationTests extends TestBase{

    @DataProvider
    public Iterator<Object[]> validTeams(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"name DP","description DP"});
        list.add(new Object[]{"DPn",""});


        return list.iterator();
    }

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getSession().isAvatarPresentOnHeader()){
            app.getSession().logoutAtlassianAss();
        }
    }

    @Test(dataProvider = "validTeams")
    public void teamCreationTestFromHeaderWithDP(String teamName, String teamDescr) throws InterruptedException {

        int teamCountBefore = app.getTeam().getTeamsCount();
        app.getBoard().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(new TeamData()
                .withTeamName(teamName)
                .withTeamDescr(teamDescr));
        app.getTeam().submitTeamCreation();

        if(app.getSession().isElementPresent(By.cssSelector("[name='close']"))){
            app.getTeam().closeInviteToTheTeamForm();
        }
        app.getTeam().clickTeamLaterButton();
        int teamCountAfter = app.getTeam().getTeamsCount();
        app.getBoard().returnToHomePage();
        Assert.assertEquals(teamCountAfter, teamCountBefore+1);
        pause();
    }


    @Test
    public void teamCreationTestFromHeader() throws InterruptedException {

        int teamCountBefore = app.getTeam().getTeamsCount();
        app.getBoard().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(new TeamData()
                .withTeamName("Meir1")
                .withTeamDescr("Ok!!!"));
        app.getTeam().submitTeamCreation();
        app.getTeam().teamTypeSelect();
        if(app.getSession().isElementPresent(By.cssSelector("[name='close']"))){
           app.getTeam(). closeInviteToTheTeamForm();
        }
        app.getTeam().clickTeamLaterButton();
        int teamCountAfter = app.getTeam().getTeamsCount();
        app.getBoard().returnToHomePage();
        Assert.assertEquals(teamCountAfter, teamCountBefore+1);
        pause();
    }


    @Test
    public void teamCreationTestFromHeaderWithNameOnly() throws InterruptedException {

        int countCountBefore = app.getTeam().getTeamsCount();
        app.getBoard().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(new TeamData()
                .withTeamName("Meir1"));
        app.getTeam().submitTeamCreation();
        if(app.getSession().isElementPresent(By.cssSelector("[name='close']"))){
            app.getTeam().closeInviteToTheTeamForm();
        }
        app.getTeam().clickTeamLaterButton();
        int TeamCountAfter = app.getTeam().getTeamsCount();
        app.getBoard().returnToHomePage();
        Assert.assertEquals(TeamCountAfter, countCountBefore + 1);
        pause();
    }


}
