package com.LexiFlash.app.Deck;

import com.LexiFlash.app.Card.Card;
import com.LexiFlash.app.Game.GameUI;
import com.LexiFlash.app.Game.Helper;
import com.LexiFlash.app.Interfaces.Editable;

public class DeckManager implements Editable<Deck> {

    @Override
    public void edit(Deck deck) {

        System.out.println("Editing deck...");
        //Options to edit properties of the deck
        String[] options = new String[deck.cards.length + 1];
        options[0] = "Add Card";

        for(int i = 0; i < deck.cards.length; i++) {
            options[i + 1] = deck.cards[i].getAsOption();
        }

        Integer option = GameUI.menu(options, "Choose a card to edit: ");

        switch (option) {
            case 0:
                break;
            case 1:
                deck.addCard(Card.createCard());
                break;
            default:
                deck.cards[option - 2].edit();
                break;
        }

        //Check for cards that have deleted flag set to true
        for (int i = 0; i < deck.cards.length; i++) {
            if(deck.cards[i].deleted) {
                deck.removeCard(i);
            }
        }

    }

    @Override
    public Deck create() {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }


    public void addCard(Deck deck, Card card) {
        Card[] newCards = new Card[deck.cards.length + 1];
        for (int i = 0; i < deck.cards.length; i++) {
            newCards[i] = deck.cards[i];
        }
        newCards[deck.cards.length] = card;
        deck.cards = newCards;
    }

    public void removeCard(Deck deck, Integer index) {
        Card[] newCards = new Card[deck.cards.length - 1];
        for (int i = 0; i < deck.cards.length; i++) {
            if(i == index) {
                continue;
            }
            newCards[i] = deck.cards[i];
        }
        deck.cards = newCards;
    }
}
