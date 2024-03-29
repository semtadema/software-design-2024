package com.lexiflash.app.deck;

import com.lexiflash.app.card.Card;
import com.lexiflash.app.interfaces.Playable;

public class DeckPlayer implements Playable<Deck, DeckResults> {

    public DeckResults play(Deck deck) {
        Card[] cards = deck.getCards();

        boolean[] solvedCards = new boolean[cards.length];
        Integer[] tries = new Integer[cards.length];
        boolean keepBadge = false;

        for (int i = 0; i < cards.length; i++) {
            solvedCards[i] = cards[i].getSolved();
        }

        if (!falsePresent(solvedCards)) {
            resetDeck(cards, solvedCards);
            keepBadge = true;
        }

        playCards(cards, solvedCards, tries);

        if (!falsePresent(solvedCards)) {
            System.out.println("Congratulations! You've solved all the cards! You've earned a badge!");
            return new DeckResults(true, tries, solvedCards, cards);
        } else {
            System.out.println("You've reached the maximum number of tries for all cards. Try again later.");
        }

        int solved = countSolvedCards(solvedCards);

        if (keepBadge) {
            System.out.println("You've earned your badge!... Again!");
            return new DeckResults(true, tries, solvedCards, cards);
        }

        if (isBadgeEarned(solved, solvedCards.length)) {
            System.out.println("You've earned a badge!");
            return new DeckResults(true, tries, solvedCards, cards);
        }

        return new DeckResults(false, tries, solvedCards, cards);
    }

    private void resetDeck(Card[] cards, boolean[] solvedCards) {
        System.out.println(
                "You've already solved all of the cards. We'll reset it for you, but don't worry you'll keep your badge ;)");
        for (int i = 0; i < cards.length; i++) {
            solvedCards[i] = false;
        }
    }

    private void playCards(Card[] cards, boolean[] solvedCards, Integer[] tries) {
        while (falsePresent(solvedCards) && notHigherThan(tries, 3)) {
            for (int i = 0; i < cards.length; i++) {
                if (solvedCards[i] || !notHigherThan(tries, 3)) {
                    continue;
                }
                solvedCards[i] = cards[i].play();
                tries[i] = (tries[i] == null) ? 1 : tries[i] + 1;
            }
        }
    }

    private static int countSolvedCards(boolean[] solvedCards) {
        int solved = 0;
        for (boolean solvedCard : solvedCards) {
            if (solvedCard) {
                solved++;
            }
        }
        return solved;
    }

    private static boolean isBadgeEarned(int solved, int totalCards) {
        return solved >= (totalCards * 0.7);
    }

    private static boolean notHigherThan(Integer[] tries, int i) {
        for (Integer integer : tries) {
            if (integer != null && integer >= i) {
                return false;
            }
        }
        return true;
    }

    private static final boolean falsePresent(boolean[] values) {
        for (boolean bool : values) {
            if (!bool) {
                return true;
            }
        }
        return false;
    }

    
}
