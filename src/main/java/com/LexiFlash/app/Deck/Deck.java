package com.LexiFlash.app.Deck;

import com.LexiFlash.app.Card.Card;

public class Deck {

    public Card[] cards;
    public int length;

    DeckUI deckUI = new DeckUI();
    DeckPlayer deckPlayer = new DeckPlayer();
    DeckManager deckManager = new DeckManager();

    public Deck(Card[] cards) {
        this.cards = cards;
        this.length = cards.length;
    }
    
    public void print() {
        deckUI.print(this);
    }

    public DeckResults play() {
        return deckPlayer.play(this);
    }

    public void edit() {
        deckManager.edit(this);
    }

    public void addCard(Card card) {
        deckManager.addCard(this, card);
    }

    public void removeCard(Integer index) {
        deckManager.removeCard(this, index);
    }

}
