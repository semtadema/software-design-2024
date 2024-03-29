package com.LexiFlash.app.Deck;

import com.LexiFlash.app.Card.Card;
import com.LexiFlash.app.Game.GameUI;
import com.LexiFlash.app.Interfaces.Editable;

public class DeckManager implements Editable<Deck> {

    @Override
    public void edit(Deck deck) {

        System.out.println("Editing deck...");
        //Options to edit properties of the deck
        String[] options = new String[deck.getCards().length + 1];
        options[0] = "Add Card";

        for(int i = 0; i < deck.getCards().length; i++) {
            options[i + 1] = deck.getCards()[i].getAsOption();
        }

        Integer option = GameUI.menu(options, "Choose a card to edit: ");

        switch (option) {
            case 0:
                break;
            case 1:
                deck.addCard(Card.createCard());
                break;
            default:
                deck.getCards()[option - 2].edit();
                break;
        }

        //Check for cards that have deleted flag set to true
        for (int i = 0; i < deck.getCards().length; i++) {
            if(deck.getCards()[i].getDeleted()) {
                deck.removeCard(i);
            }
        }

    }

    @Override
    public Deck create() {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }


    public void addCard(Deck deck, Card card) {
        Card[] newCards = new Card[deck.getCards().length + 1];
        System.arraycopy(deck.getCards(), 0, newCards, 0, deck.getCards().length);
        newCards[deck.getCards().length] = card;
        deck.setCards(newCards);
    }

    public void removeCard(Deck deck, Integer index) {
        Card[] newCards = new Card[deck.getCards().length - 1];
        for (int i = 0; i < deck.getCards().length; i++) {
            if(i == index) {
                continue;
            }
            newCards[i] = deck.getCards()[i];
        }
        deck.setCards(newCards);
    }
}
