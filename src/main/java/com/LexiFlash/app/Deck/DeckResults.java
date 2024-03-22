package com.LexiFlash.app.Deck;

import java.util.Arrays;

import com.LexiFlash.app.Card.Card;

public class DeckResults {
    
    public boolean receivedBadge;
    public Integer[] tries;
    public boolean[] solvedCards;
    public Card[] cards;

    public DeckResults(boolean receivedBadge, Integer[] tries, boolean[] solvedCards, Card[] cards) {
        this.receivedBadge = receivedBadge;
        this.tries = tries;
        this.solvedCards = solvedCards;
        this.cards = cards;
    }

    public void print() {
        System.out.println("These are your results...");
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
        System.out.println("Top 3 hardest cards to solve:");
        //Sort the cards by tries
        Arrays.sort(this.tries);

        int max = this.tries.length > 3 ? 3 : this.tries.length;

        for(int i = 0; i < max; i++) {
            cards[i].print();
        }
    }

    private void topThreeEasiest() {
        System.out.println("Top 3 easiest cards to solve:");
        //Sort the cards by tries
        Arrays.sort(this.tries);

        int max = this.tries.length > 3 ? 3 : this.tries.length;

        for(int i = this.tries.length - 1; i > this.tries.length - max; i--) {
            cards[i].print();
        }
    }

    private void averageTries() {
        Integer sum = 0;
        for(int i = 0; i < this.tries.length; i++) {
            sum += this.tries[i];
        }
        System.out.println("Average number of tries: " + sum / this.tries.length);
    }

    private void percentageSolved() {
        Integer solved = 0;
        for(int i = 0; i < this.solvedCards.length; i++) {
            if(this.solvedCards[i]) {
                solved++;
            }
        }
        System.out.println("Percentage of cards solved: " + (solved / this.solvedCards.length) * 100 + "%");
    }

    private void badge() {
        if(this.receivedBadge) {
            System.out.println("You've achieved the badge!");
        } else {
            System.out.println("You didn't achieve the badge. Try again!");
        }
    }

}
