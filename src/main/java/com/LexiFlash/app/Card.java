package com.LexiFlash.app;

public class Card {

    private String fromWord;
    private String toWord;
    private String fromHint;
    private String toMeaning;
    private boolean solved;

    public Card(String fromWord, String toWord, String fromHint, String toMeaning, boolean solved) {
        this.fromWord = fromWord;
        this.toWord = toWord;
        this.fromHint = fromHint;
        this.toMeaning = toMeaning;
        this.solved = solved;
    }

    public void print() {
        System.out.println("From: " + fromWord + " - To: " + toWord);
        System.out.println("Hint: " + fromHint + " - Meaning: " + toMeaning);
        System.out.println("Solved: " + solved);
    }

}
