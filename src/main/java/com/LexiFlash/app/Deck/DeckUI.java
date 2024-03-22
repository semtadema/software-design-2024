package com.LexiFlash.app.Deck;

import com.LexiFlash.app.Card.Card;
import com.LexiFlash.app.Interfaces.Printable;

public class DeckUI implements Printable<Deck> {

    @Override
    public void print(Deck deck) {
        for (Card card : deck.cards) {
            card.print();
        }
    }
    
}
