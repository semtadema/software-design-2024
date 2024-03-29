package com.lexiflash.app.level;

import com.lexiflash.app.card.Card;
import com.lexiflash.app.deck.Deck;
import com.lexiflash.app.game.GameManager;
import com.lexiflash.app.game.GameUI;
import com.lexiflash.app.interfaces.Editable;

public class LevelManager implements Editable<Level> {

    @Override
    public void edit(Level level) {
        System.out.println("Editing level... " + level.getLabel());
        //Options to edit properties of the level
        String[] options = {"Name: " + level.getName(), "Label: " + level.getLabel(), "From Language: " + level.getFromLanguage(), "To Language: " + level.getToLanguage(), "Deck", "Remove"};

        Integer option = GameUI.menu(options, "Choose a property to edit: ");

        switch (option) {
            case 1:
                System.out.println("Enter the new name: ");
                level.setName(System.console().readLine());
                break;
            case 2:
                System.out.println("Enter the new label: ");
                level.setLabel(System.console().readLine());
                break;
            case 3:
                System.out.println("Enter the new from language: ");
                level.setFromLanguage(System.console().readLine());
                break;
            case 4:
                System.out.println("Enter the new to language: ");
                level.setToLanguage(System.console().readLine());
                break;
            case 5:
                level.getDeck().edit();
                break;
            case 6:
                GameManager.removeLevel(level);
                break;
            default:
                break;
        }

        GameManager.saveLevel(level);

    }

    @Override
    public Level create() {

        GameUI.clearConsole();

        System.out.println("Creating a new level...");
        System.out.print("Name: ");
        String name = System.console().readLine();
        System.out.print("Label: ");
        String label = System.console().readLine();
        System.out.print("From Language: ");
        String fromLanguage = System.console().readLine();
        System.out.print("To Language: ");
        String toLanguage = System.console().readLine();
        String id = java.util.UUID.randomUUID().toString();

        return new Level(id, name, label, fromLanguage, toLanguage, new Deck(new Card[0]), false);
    }
    
}
