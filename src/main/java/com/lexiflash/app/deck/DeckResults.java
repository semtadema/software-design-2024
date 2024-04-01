package com.lexiflash.app.deck;

import java.util.Arrays;

import com.lexiflash.app.card.Card;
import com.lexiflash.app.game.GameUI;

public class DeckResults {
    
    private boolean receivedBadge;
    private Integer[] tries;
    private boolean[] solvedCards;
    private Card[] cards;

    public DeckResults(boolean receivedBadge, Integer[] tries, boolean[] solvedCards, Card[] cards) {
        this.receivedBadge = receivedBadge;
        this.tries = tries;
        this.solvedCards = solvedCards;
        this.cards = cards;
    }

    public void print() {
        System.out.println(GameUI.YELLOW + "These are your results..." + GameUI.RESET);
        //Top 3 hardest cards to solve
        topThreeHardest();
        //Top 3 easiest cards to solve
        topThreeEasiest();

        //Average number of tries
        averageTries();

        //Percentage of cards solved
        percentageSolved();

        //Badge
        badge();
    }

    private void topThreeHardest() {
        System.out.println(GameUI.YELLOW + "Top 3 hardest cards to solve:" + GameUI.RESET);
        
        if(this.tries.length == 0) {
            System.out.println(GameUI.YELLOW + "No cards to show." + GameUI.RESET);
            return;
        }

        if(this.tries.length == 1) {
            this.cards[0].print();
            return;
        }

        //Sort the cards by tries
        Arrays.sort(this.tries);

        int max = this.tries.length > 3 ? 3 : this.tries.length;

        for(int i = 0; i < max; i++) {
            cards[i].print();
        }
    }

    private void topThreeEasiest() {
        System.out.println(GameUI.YELLOW + "Top 3 easiest cards to solve:" + GameUI.RESET);
        //Sort the cards by tries
        Arrays.sort(this.tries);

        int max = this.tries.length > 3 ? 3 : this.tries.length;

        for(int i = this.tries.length - 1; i >= this.tries.length - max; i--) {
            cards[i].print();
        }
    }

    private void averageTries() {
        Integer sum = 0;
        for(int i = 0; i < this.tries.length; i++) {
            sum += this.tries[i];
        }
        System.out.println(GameUI.YELLOW + "Average number of tries: " + sum / this.tries.length + GameUI.RESET);
    }

    private void percentageSolved() {
        Integer solved = 0;
        for(int i = 0; i < this.solvedCards.length; i++) {
            if(this.solvedCards[i]) {
                solved++;
            }
        }
        System.out.println(GameUI.YELLOW + "Percentage of cards solved: " + (solved / this.solvedCards.length) * 100 + "%" + GameUI.RESET);
    }

    private void badge() {
        if(this.receivedBadge) {
            System.out.println(GameUI.GREEN + "You've achieved the badge!" + GameUI.RESET);
        } else {
            System.out.println(GameUI.RED + "You didn't achieve the badge. Try again!" + GameUI.RESET);
        }
    }

    public boolean getReceivedBadge() {
        return this.receivedBadge;
    }

}
