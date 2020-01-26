package com.meir.trello.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    HeaderHelper header = new HeaderHelper(wd);


    public SessionHelper(WebDriver wd) {
        super(wd);
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
        header.clickOnAvatar();
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
}
