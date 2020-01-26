package com.meir.trello.manager;

import com.meir.trello.model.TeamData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase{
    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void selectCreateTeamFromDropDown() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public void fillTeamCreationForm(TeamData teamData) throws InterruptedException {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamData.getTeamName());
        type(By.cssSelector("[id$=description]"), teamData.getTeamDescr());
    }

    public void submitTeamCreation() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }

    public void closeInviteToTheTeamForm() throws InterruptedException {
        click(By.cssSelector("[name='close']"));
    }

    public void clickTeamLaterButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='show-later-button']"));
    }

    public int getTeamsCount() {
        return wd.findElements(By.cssSelector("[data-test-id^=home-team-tab-section]")).size();
    }

    public void clickOnTheTeam() throws InterruptedException {
        click(By.cssSelector("[data-test-id^=home-team-tab-section]"));
    }

    public void clickOnTeamSettings() throws InterruptedException {
        click(By.cssSelector("[class^=icon-gear]"));
    }

    public void clickOnDeleteTeamButton() throws InterruptedException {
        click(By.xpath("//*[@class='quiet-button']"));
    }

    public void changeTeamName() throws InterruptedException {
        click(By.cssSelector("[name='displayName']"));
        wd.findElement(By.cssSelector("[name='displayName']")).clear();
        wd.findElement(By.cssSelector("[name='displayName']")).sendKeys("Test");
        //click on save button
        click(By.cssSelector(".primary.wide.js-submit-profile"));
    }

    public void clickOnEditTeamProfileButton() throws InterruptedException {
        click(By.cssSelector(".js-edit-profile"));
    }
    public void submitDeletion() throws InterruptedException {
        click(By.cssSelector("[value='Delete Forever']"));
    }

}
