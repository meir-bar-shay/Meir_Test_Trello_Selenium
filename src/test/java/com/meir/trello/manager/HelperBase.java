package com.meir.trello.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public  boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void type(By locator, String text) throws InterruptedException {
        if (text != null){

            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }

    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void click(By locator) throws InterruptedException {
        wd.findElement(locator).click();
        pause(2000);
    }

    public void returnToHomePage() throws InterruptedException {
        click(By.name("house"));
        click(By.name("house"));
    }
}
