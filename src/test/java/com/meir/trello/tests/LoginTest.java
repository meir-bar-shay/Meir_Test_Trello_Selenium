package com.meir.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(app.getSession().isAvatarPresentOnHeader()){
            app.getSession().logout();
        }

        
    }

    @Test
    public void testLogInWithAtlassianAcc() throws InterruptedException {
        app.getSession().clickLoginLink();
        app.getSession().fillLoginFormAtlassianAcc("meir.bar.shay@gmail.com", "Trello2019");
        app.getBoard().pause(20000);
        Assert.assertTrue(app.getSession().isAvatarPresentOnHeader());
    }

    @Test
    public void testLogInWithAtlassianAcc1() throws InterruptedException {
        app.getSession().clickLoginLink();
        app.getSession().fillLoginFormAtlassianAcc("meir.bar.shay@gmail.com", "Trello2019");
        app.getBoard().pause(20000);
        Assert.assertTrue(app.getSession().isAvatarPresentOnHeader());
    }
}