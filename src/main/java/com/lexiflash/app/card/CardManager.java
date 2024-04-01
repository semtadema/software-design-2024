package com.lexiflash.app.card;

import com.lexiflash.app.game.GameUI;
import com.lexiflash.app.interfaces.Editable;

public class CardManager implements Editable<Card> {

    public void edit(Card card) {
        System.out.println(GameUI.YELLOW + "Editing card: " +  card.getFromWord() + GameUI.RESET);
        String[] options = new String[] {"From", "To", "Hint", "Meaning", "Remove"};

        Integer option = GameUI.menu(options, "Choose a property to edit: ");

        switch (option) {
            case 0:
                break;
            case 1:
                System.out.println("From: ");
                card.setFromWord(System.console().readLine());
                break;
            case 2:
                System.out.println("To: ");
                card.setToWord(System.console().readLine());
                break;
            case 3:
                System.out.println("Hint: ");
                card.setFromHint(System.console().readLine());
                break;
            case 4:
                System.out.println("Meaning: ");
                card.setToMeaning(System.console().readLine());
                break;
            case 5:
                card.setDeleted(true);
                break;
            default:
                System.out.println(GameUI.YELLOW + "Invalid option" + GameUI.RESET);
                break;
        }
    }

    @Override
    public Card create() {
        System.out.println(GameUI.YELLOW + "Creating a new card..." + GameUI.RESET);
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
