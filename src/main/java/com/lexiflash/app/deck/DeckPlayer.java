package com.lexiflash.app.deck;

import com.lexiflash.app.card.Card;
import com.lexiflash.app.game.GameUI;
import com.lexiflash.app.interfaces.Playable;

import java.util.Arrays;

public class DeckPlayer implements Playable<Deck, DeckResults> {

    public DeckResults play(Deck deck) {
        Card[] cards = deck.getCards();

        boolean[] solvedCards = new boolean[cards.length];
        Integer[] tries = new Integer[cards.length];
        Arrays.fill(tries, 0);
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
            System.out.println(GameUI.GREEN + "Congratulations! You've solved all the cards! You've earned a badge!" + GameUI.RESET);
            return new DeckResults(true, tries, solvedCards, cards);
        } else {
            System.out.println(GameUI.RED + "You've reached the maximum number of tries for all cards. Try again later." + GameUI.RESET);
        }

        int solved = countSolvedCards(solvedCards);

        if (keepBadge) {
            System.out.println(GameUI.GREEN + "You've earned your badge!... Again!" + GameUI.RESET);
            return new DeckResults(true, tries, solvedCards, cards);
        }

        if (isBadgeEarned(solved, solvedCards.length)) {
            System.out.println(GameUI.GREEN + "You've earned a badge!" + GameUI.RESET);
            return new DeckResults(true, tries, solvedCards, cards);
        }

        return new DeckResults(false, tries, solvedCards, cards);
    }

    private void resetDeck(Card[] cards, boolean[] solvedCards) {
        System.out.println( GameUI.YELLOW +
                "You've already solved all of the cards. We'll reset it for you, but don't worry you'll keep your badge ;)" + GameUI.RESET);
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
