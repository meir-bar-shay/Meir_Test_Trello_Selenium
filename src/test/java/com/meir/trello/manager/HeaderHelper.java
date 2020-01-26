package com.meir.trello.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase{


    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void clickOnAvatar() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void returnToHomePage() throws InterruptedException {
        click(By.name("house"));
        click(By.name("house"));
    }
}
