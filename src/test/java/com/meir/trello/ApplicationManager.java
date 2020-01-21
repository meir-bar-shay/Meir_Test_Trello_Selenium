package com.meir.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    BoardHelper boardHelper;

     WebDriver wd;

    public void init() {
        String browser = System.getProperty("browser", BrowserType.CHROME);
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.get("https://trello.com/");

        boardHelper = new BoardHelper(wd);
    }

    public  boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void type(By locator, String text) throws InterruptedException {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void click(By locator) throws InterruptedException {
        wd.findElement(locator).click();
        pause(2000);
    }

    public void stop() {
        wd.quit();
    }



    public void fillLoginFormAtlassianAcc(String user, String pwd) throws InterruptedException {
        type(By.id("user"), user);
        pause(2000);
        click(By.id("login"));
        click(By.id("login-submit"));
        type(By.id("password"), pwd);
        pause(2000);
        click(By.id("login-submit"));
    }

    public void confirmLogin() throws InterruptedException {
        click(By.id("login"));
    }



    public void fillLoginFormOldAcc(String userName, String password) throws InterruptedException {
        type(By.id("user"), userName);
        type(By.id("password"), password);
    }



    public void clickLoginLink() throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
    }

    public void loginWhithBothAccs() throws InterruptedException {

        type(By.id("user"), "meir.bar.shay@gmail.com");
        Thread.sleep(8000);
        if(wd.findElement(By.id("password")).isDisplayed()){
            type(By.id("password"), "Trello2019");
        }
        click(By.id("login"));

        if (isElementPresent(By.id("login-submit"))){
            click(By.id("login-submit"));

            type(By.id("password"), "Trello2019");
            click(By.id("login-submit"));
        }
    }

    public boolean isAvatarPresentOnHeader() {
        return isElementPresent
                (By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void logout() throws InterruptedException {
        clickOnAvatar();
        clickLogoutButton();
    }

    public void logoutAtlassianAss() throws InterruptedException {
        clickLoginLink();
        fillLoginFormAtlassianAcc("meir.bar.shay@gmail.com", "Trello2019");
        pause(5000);
    }

    public void clickLogoutButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void returnToHomePage() throws InterruptedException {
        click(By.name("house"));
        click(By.name("house"));
    }

    public void selectCreateTeamFromDropDown() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public void fillTeamCreationForm(String teamName, String teamDescr) throws InterruptedException {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.cssSelector("[id$=description]"), teamDescr);
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

    public void submitDeletion() throws InterruptedException {
        click(By.cssSelector("[value='Delete Forever']"));
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

    public BoardHelper getBoardHelper() {
        return boardHelper;
    }
}
