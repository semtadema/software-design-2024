package com.LexiFlash.app;

public class Level {

    private String name;
    private String label;
    private String fromLanguage;
    private String toLanguage;
    private Card[] cards;

    public Level(String name, String label, String fromLanguage, String toLanguage, Card[] cards) {
        this.name = name;
        this.label = label;
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
        this.cards = cards;
    }

    public void print() {
        System.out.println("Level: " + name + " - " + label);
        System.out.println("From: " + fromLanguage + " - To: " + toLanguage);
        System.out.println("Total Cards: " + cards.length);
        for (Card card : cards) {
            card.print();
        }
        System.out.println();
        System.out.println();
    }

}
