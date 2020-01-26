package com.meir.trello.model;

public class BoardData {
    private String boardName;

    public BoardData setBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public String getBoardName() {
        return boardName;
    }
}
