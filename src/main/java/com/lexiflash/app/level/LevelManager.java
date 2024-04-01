package com.lexiflash.app.level;

import com.lexiflash.app.card.Card;
import com.lexiflash.app.deck.Deck;
import com.lexiflash.app.game.GameManager;
import com.lexiflash.app.game.GameUI;
import com.lexiflash.app.interfaces.Editable;

public class LevelManager implements Editable<Level> {

    @Override
    public void edit(Level level) {
        System.out.println(GameUI.YELLOW + "Editing level... " + level.getLabel() + GameUI.RESET);
        //Options to edit properties of the level
        String[] options = {"Name: " + level.getName(), "Label: " + level.getLabel(), "From Language: " + level.getFromLanguage(), "To Language: " + level.getToLanguage(), "Deck", "Remove"};

        Integer option = GameUI.menu(options, "Choose a property to edit: ");

        switch (option) {
            case 1:
                System.out.println(GameUI.YELLOW + "Enter the new name: " + GameUI.RESET);
                level.setName(System.console().readLine());
                break;
            case 2:
                System.out.println(GameUI.YELLOW + "Enter the new label: " + GameUI.RESET);
                level.setLabel(System.console().readLine());
                break;
            case 3:
                System.out.println(GameUI.YELLOW + "Enter the new from language: " + GameUI.RESET);
                level.setFromLanguage(System.console().readLine());
                break;
            case 4:
                System.out.println(GameUI.YELLOW + "Enter the new to language: " + GameUI.RESET);
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

        System.out.println(GameUI.YELLOW + "Creating a new level..." + GameUI.RESET);
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
