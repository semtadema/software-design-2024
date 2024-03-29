package com.LexiFlash.app.Card;

public class Card {

    private String id;
    private String fromWord;
    private String toWord;
    private String fromHint;
    private String toMeaning;
    private boolean solved;

    CardUI cardUI = new CardUI();
    CardManager cardManager = new CardManager();
    CardPlayer cardPlayer = new CardPlayer();
    private boolean deleted = false;

    public Card(String id, String fromWord, String toWord, String fromHint, String toMeaning, boolean solved) {
        this.id = id;
        this.fromWord = fromWord;
        this.toWord = toWord;
        this.fromHint = fromHint;
        this.toMeaning = toMeaning;
        this.solved = solved;
    }
    public String getAsOption() {
        return fromWord + " - " + toWord;
    }

    public static Card createCard() {
        CardManager cardManager = new CardManager();
        return cardManager.create();
    }

    public void print()  {
        cardUI.print(this);
    }

    public Boolean play() {
        return cardPlayer.play(this);
    }

    public void edit() {
        cardManager.edit(this);
    }

    public String getId() {
        return id;
    }

    public String getFromWord() {
        return fromWord;
    }

    public String getToWord() {
        return toWord;
    }

    public String getFromHint() {
        return fromHint;
    }

    public String getToMeaning() {
        return toMeaning;
    }

    public boolean getSolved() {
        return solved;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setFromWord(String fromWord) {
        this.fromWord = fromWord;
    }

    public void setToWord(String toWord) {
        this.toWord = toWord;
    }

    public void setFromHint(String fromHint) {
        this.fromHint = fromHint;
    }

    public void setToMeaning(String toMeaning) {
        this.toMeaning = toMeaning;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
