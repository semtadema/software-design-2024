package com.LexiFlash.app.Card;

import com.LexiFlash.app.Game.GameUI;
import com.LexiFlash.app.Game.Helper;
import com.LexiFlash.app.Interfaces.Editable;

public class CardManager implements Editable<Card> {

    public void edit(Card card) {
        System.out.println("Editing card...");
        String[] options = new String[] {"From", "To", "Hint", "Meaning"};

        Integer option = GameUI.menu(options, "Choose a property to edit: ");

        switch (option) {
            case 1:
                System.out.println("From: ");
                card.fromWord = System.console().readLine();
                break;
            case 2:
                System.out.println("To: ");
                card.toWord = System.console().readLine();
                break;
            case 3:
                System.out.println("Hint: ");
                card.fromHint = System.console().readLine();
                break;
            case 4:
                System.out.println("Meaning: ");
                card.toMeaning = System.console().readLine();
                break;
        }

        Helper.saveGame();
    }

    @Override
    public Card create() {
        System.out.println("Creating a new card...");
        System.out.println("From: ");
        String fromWord = System.console().readLine();
        System.out.println("To: ");
        String toWord = System.console().readLine();
        System.out.println("Hint: ");
        String fromHint = System.console().readLine();
        System.out.println("Meaning: ");
        String toMeaning = System.console().readLine();
        String id = java.util.UUID.randomUUID().toString();

        return new Card(id, fromWord, toWord, fromHint, toMeaning, false);
    }    
}
