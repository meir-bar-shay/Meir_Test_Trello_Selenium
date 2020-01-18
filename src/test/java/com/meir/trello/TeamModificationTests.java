package com.meir.trello;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            logoutAtlassianAss();
        }
    }

    @Test
    public void modificationTeamName() throws InterruptedException {
        clickOnTheTeam();
        clickOnTeamSettings();
        clickOnEditTeamProfileButton();
        changeTeamName();
        returnToHomePage();
//        clickOnTheTeam();
//        clickOnTeamSettings();
//        String name = getText(By.cssSelector(".u-inline"));
//        System.out.println(name);

    }

}
