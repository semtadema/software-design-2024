package com.LexiFlash.app.Deck;

import com.LexiFlash.app.Card.Card;
import com.LexiFlash.app.Interfaces.Playable;

public class DeckPlayer implements Playable<Deck, DeckResults> {

    private Card[] cards;

    public DeckResults play(Deck deck) {

        this.cards = deck.cards;

        boolean[] solvedCards = new boolean[this.cards.length];
        Integer[] tries = new Integer[this.cards.length];
        boolean keepBadge = false;

        for (int i = 0; i < this.cards.length; i++) {
            solvedCards[i] = this.cards[i].solved;
        }

        if (!falsePresent(solvedCards)) {
            System.out.println(
                    "You've already solved all of the cards. We'll reset it for you, but don't worry you'll keep your badge ;)");
            // Reset the deck
            for (int i = 0; i < this.cards.length; i++) {
                solvedCards[i] = false;
            }
            keepBadge = true;
        }

        while (falsePresent(solvedCards) && notHigherThan(tries, 3)) {
            for (int i = 0; i < cards.length; i++) {
                if (solvedCards[i] || !notHigherThan(tries, 3)) {
                    continue;
                }
                solvedCards[i] = this.cards[i].play();
                tries[i] = (tries[i] == null) ? 1 : tries[i] + 1;
            }
        }

        if (!falsePresent(solvedCards)) {
            System.out.println("Congratulations! You've solved all the cards! You've earned a badge!");
            return new DeckResults(true, tries, solvedCards, this.cards);
        } else {
            System.out.println("You've reached the maximum number of tries for all cards. Try again later.");
        }

        // Check if more than 70% of the cards are solved and give a badge
        int solved = 0;
        for (int i = 0; i < solvedCards.length; i++) {
            if (solvedCards[i]) {
                solved++;
            }
        }

        if (keepBadge) {
            System.out.println("You've earned your badge!... Again!");
            return new DeckResults(true, tries, solvedCards, this.cards);
        }

        if (solved >= (solvedCards.length * 0.7)) {
            System.out.println("You've earned a badge!");
            return new DeckResults(true, tries, solvedCards, this.cards);
        }

        return new DeckResults(false, tries, solvedCards, this.cards);
    }

    private static boolean notHigherThan(Integer[] tries, int i) {
        for (Integer integer : tries) {
            if (integer != null && integer >= i) {
                return false;
            }
        }
        return true;
    }

    private final static boolean falsePresent(boolean[] values) {
        for (boolean bool : values) {
            if (!bool) {
                return true;
            }
        }
        return false;
    }
}
