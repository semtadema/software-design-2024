package com.LexiFlash.app;

public class Deck {

    private Card[] cards;
    public int length;

    public Deck(Card[] cards) {
        this.cards = cards;
        this.length = cards.length;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
    
    public void addCard(Card card) {
        Card[] newCards = new Card[cards.length + 1];
        for (int i = 0; i < cards.length; i++) {
            newCards[i] = cards[i];
        }
        newCards[cards.length] = card;
        cards = newCards;
        Helper.saveGame();
    }

    public void removeCard(Integer index) {
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

    public void print() {
        for (Card card : cards) {
            card.print();
        }
    }

    public DeckResults play() {
        boolean[] solvedCards = new boolean[this.cards.length];
        Integer[] tries = new Integer[this.cards.length];
        boolean keepBadge = false;


        for(int i = 0; i < this.cards.length; i++) {
            solvedCards[i] = this.cards[i].getSolved();
        }

        if(!Helper.falsePresent(solvedCards)) {
            System.out.println("You've already solved all of the cards. We'll reset it for you, but don't worry you'll keep your badge ;)");
            //Reset the deck
            for(int i = 0; i < this.cards.length; i++) {
                solvedCards[i] = false;
            }            
            keepBadge = true;
        }
        
        while (Helper.falsePresent(solvedCards) && Helper.notHigherThan(tries, 3)) {
            for (int i = 0; i < cards.length; i++) {
                if(solvedCards[i] || !Helper.notHigherThan(tries, 3)) {
                    continue;
                }
                solvedCards[i] = this.cards[i].play();
                tries[i] = (tries[i] == null) ? 1 : tries[i] + 1;
              }
        }

        if(!Helper.falsePresent(solvedCards)) {
            System.out.println("Congratulations! You've solved all the cards! You've earned a badge!");
            return new DeckResults(true, tries, solvedCards, this.cards);
        } else {
            System.out.println("You've reached the maximum number of tries for all cards. Try again later.");
        }

        //Check if more than 70% of the cards are solved and give a badge
        int solved = 0;
        for (int i = 0; i < solvedCards.length; i++) {
            if(solvedCards[i]) {
                solved++;
            }
        }

        if(keepBadge) {
            System.out.println("You've earned your badge!... Again!");
            return new DeckResults(true, tries, solvedCards, this.cards);
        }

        if(solved >= (solvedCards.length * 0.7)) {
            System.out.println("You've earned a badge!");
            return new DeckResults(true, tries, solvedCards, this.cards);
        }

        return new DeckResults(false, tries, solvedCards, this.cards);
        
    }

    public void edit() {
        System.out.println("Editing deck...");
        //Options to edit properties of the deck
        String[] options = new String[this.cards.length + 2];
        options[0] = "Add Card";
        options[1] = "Remove Card";

        for(int i = 0; i < this.cards.length; i++) {
            options[i + 2] = this.cards[i].getAsOption();
        }

        Integer option = Helper.menu(options, "Choose a card to edit: ");

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

    private Integer indexCards() {
        String[] options = new String[this.cards.length];
        for (int i = 0; i < this.cards.length; i++) {
            options[i] = this.cards[i].getAsOption();
        }

        int option = Helper.menu(options, "Choose a card: ");

        return option;
    }

}
