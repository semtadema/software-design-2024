package com.LexiFlash.app.Card;

public class Card {

    public String id;
    public String fromWord;
    public String toWord;
    public String fromHint;
    public String toMeaning;
    public boolean solved;

    CardUI cardUI = new CardUI();
    CardManager cardManager = new CardManager();
    CardPlayer cardPlayer = new CardPlayer();

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
    
    
}
