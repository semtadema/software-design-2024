package com.lexiflash.app.deck;

import com.lexiflash.app.card.Card;
import com.lexiflash.app.interfaces.Printable;

public class DeckUI implements Printable<Deck> {

    @Override
    public void print(Deck deck) {
        for (Card card : deck.getCards()) {
            card.print();
        }
    }
    
}
