package com.LexiFlash.app.Card;

import com.LexiFlash.app.Interfaces.Printable;

public class CardUI implements Printable<Card> {
    public void print(Card card) {
        System.out.println("From: " + card.getFromWord() + " - To: " + card.getToWord());
        System.out.println("Hint: " + card.getFromHint() + " - Meaning: " + card.getToMeaning());
        System.out.println("Solved: " + card.getSolved());
    }
}
