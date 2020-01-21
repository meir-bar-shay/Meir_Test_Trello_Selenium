package com.meir.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmBoardCreation() throws InterruptedException {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void fillBoardForm(String boardName) throws InterruptedException {
        type(By.cssSelector("[data-test-id='create-board-title-input']"),boardName);
    }

    public void selectCreateBoardFromDropDown() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void clickOnPlusButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public  int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='boards-page-board-section-list']/../../..//li")).size()-1;
    }

    public void permanentlyDeleteBoard() throws InterruptedException {
        click(By.cssSelector("[class='js-confirm full negate']"));
    }

    public void permanentlyBoard() throws InterruptedException {
        click(By.cssSelector("[class='quiet js-delete']"));
    }

    public void clickButtonCloseBoard() throws InterruptedException {
        click(By.cssSelector("[class='js-confirm full negate']"));
    }

    public void selectCloseBoardButton() throws InterruptedException {
        click(By.cssSelector("[class='board-menu-navigation-item-link js-close-board']"));
    }

    public void openMoreBoard() throws InterruptedException {
        click(By.cssSelector("[class='board-menu-navigation-item-link js-open-more']"));
    }

    public boolean boardIsSuccessfullyClicked()
    {
        try
        {
            click(By.xpath("//*[@class='boards-page-board-section-list']//li[1 != last()]"));
            return true;
        }catch(Exception exception)
        {
            return false;
        }
    }

    public void boardDeletionProcess() throws InterruptedException {
        openMoreBoard();
        selectCloseBoardButton();
        clickButtonCloseBoard();
        permanentlyBoard();
        permanentlyDeleteBoard();
        returnToHomePage();
        pause(5000);
    }
}
