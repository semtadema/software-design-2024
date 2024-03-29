package com.lexiflash.app.card;

import com.lexiflash.app.game.GameManager;
import com.lexiflash.app.game.GameUI;
import com.lexiflash.app.interfaces.Playable;

public class CardPlayer implements Playable<Card,Boolean> {

    public Boolean play(Card card) {
        System.out.println("Guess the meaning of the card: " + card.getFromWord());
        System.out.println("What is the correct translation: ");
        String answer = System.console().readLine();

        if(answer.equals(card.getToWord())) {
            card.setSolved(true);
            System.out.println("Yay that's correct!");
            GameUI.sleep(1);
            GameUI.clearConsole();
        } else {
            card.setSolved(false);
            System.out.println("Oops that's wrong the correct answer is: " + card.getToWord());
            GameUI.sleep(2);
            GameUI.clearConsole();
        }

        //Save the card
        GameManager.saveCard(card);

        return card.getSolved();
    }
}
