package com.LexiFlash.app.Deck;

import com.LexiFlash.app.Card.Card;
import com.LexiFlash.app.Game.GameUI;
import com.LexiFlash.app.Game.Helper;
import com.LexiFlash.app.Interfaces.Editable;

public class DeckManager implements Editable<Deck> {

    public Card[] cards;

    @Override
    public void edit(Deck deck) {

        this.cards = deck.cards;

        System.out.println("Editing deck...");
        //Options to edit properties of the deck
        String[] options = new String[this.cards.length + 2];
        options[0] = "Add Card";
        options[1] = "Remove Card";

        for(int i = 0; i < this.cards.length; i++) {
            options[i + 2] = this.cards[i].getAsOption();
        }

        Integer option = GameUI.menu(options, "Choose a card to edit: ");

        switch (option) {
            case 1:
                this.addCard(Card.createCard());
                break;
            case 2:
                Integer selectedCard = indexCards();
                if(selectedCard == 0)
                    break;
                this.removeCard(selectedCard);
                break;
            default:
                this.cards[option - 2].edit();
                break;
        }
    }

    @Override
    public Deck create() {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }


    private void addCard(Card card) {
        Card[] newCards = new Card[cards.length + 1];
        for (int i = 0; i < cards.length; i++) {
            newCards[i] = cards[i];
        }
        newCards[cards.length] = card;
        cards = newCards;
        Helper.saveGame();
    }

    private void removeCard(Integer index) {
        Card[] newCards = new Card[cards.length - 1];
        for (int i = 0; i < cards.length; i++) {
            if(i == index) {
                continue;
            }
            newCards[i] = cards[i];
        }
        cards = newCards;
        Helper.saveGame();
    }


    private Integer indexCards() {
        String[] options = new String[this.cards.length];
        for (int i = 0; i < this.cards.length; i++) {
            options[i] = this.cards[i].getAsOption();
        }

        int option = GameUI.menu(options, "Choose a card: ");

        return option;
    }

}
