package com.LexiFlash.app.Card;

import com.LexiFlash.app.Interfaces.Printable;

public class CardUI implements Printable<Card> {
    public void print(Card card) {
        System.out.println("From: " + card.fromWord + " - To: " + card.toWord);
        System.out.println("Hint: " + card.fromHint + " - Meaning: " + card.toMeaning);
        System.out.println("Solved: " + card.solved);
    }
}
