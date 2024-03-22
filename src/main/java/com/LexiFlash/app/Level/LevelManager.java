package com.LexiFlash.app.Level;

import com.LexiFlash.app.Game.GameUI;
import com.LexiFlash.app.Game.Helper;
import com.LexiFlash.app.Interfaces.Editable;

public class LevelManager implements Editable<Level> {

    @Override
    public void edit(Level level) {
        System.out.println("Editing level... " + level.label);
        //Options to edit properties of the level
        String[] options = {"Name: " + level.name, "Label: " + level.label, "From Language: " + level.fromLanguage, "To Language: " + level.toLanguage, "Deck"};

        Integer option = GameUI.menu(options, "Choose a property to edit: ");

        switch (option) {
            case 1:
                System.out.println("Enter the new name: ");
                level.name = System.console().readLine();
                break;
            case 2:
                System.out.println("Enter the new label: ");
                level.label = System.console().readLine();
                break;
            case 3:
                System.out.println("Enter the new from language: ");
                level.fromLanguage = System.console().readLine();
                break;
            case 4:
                System.out.println("Enter the new to language: ");
                level.toLanguage = System.console().readLine();
                break;
            case 5:
                level.deck.edit();
                break;
            default:
                break;
        }

        Helper.saveGame();
    }

    @Override
    public Level create() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    
}
