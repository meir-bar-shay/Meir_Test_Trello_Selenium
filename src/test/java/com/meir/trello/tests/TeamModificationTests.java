package com.meir.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().logoutAtlassianAss();
        }
    }

    @Test
    public void modificationTeamName() throws InterruptedException {
        app.getTeam().clickOnTheTeam();
        app.getTeam().clickOnTeamSettings();
        app.getTeam().clickOnEditTeamProfileButton();
        app.getTeam().changeTeamName();
        app.getBoard().returnToHomePage();
//        clickOnTheTeam();
//        clickOnTeamSettings();
//        String name = getText(By.cssSelector(".u-inline"));
//        System.out.println(name);

    }

}
