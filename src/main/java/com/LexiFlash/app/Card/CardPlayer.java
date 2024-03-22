package com.LexiFlash.app.Card;

import com.LexiFlash.app.Game.GameUI;
import com.LexiFlash.app.Game.Helper;
import com.LexiFlash.app.Interfaces.Playable;

public class CardPlayer implements Playable<Card,Boolean> {

    public Boolean play(Card card) {
        System.out.println("Guess the meaning of the card: " + card.fromWord);
        System.out.println("What is the correct translation: ");
        String answer = System.console().readLine();

        if(answer.equals(card.toWord)) {
            card.solved = true;
            System.out.println("Yay that's correct!");
            GameUI.sleep(1);
            GameUI.clearConsole();
        } else {
            card.solved = false;
            System.out.println("Oops that's wrong the correct answer is: " + card.toWord);
            GameUI.sleep(2);
            GameUI.clearConsole();
        }

        Helper.saveGame();

        return card.solved;
    }
}
