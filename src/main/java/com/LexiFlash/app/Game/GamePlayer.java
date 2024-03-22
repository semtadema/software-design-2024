package com.LexiFlash.app.Game;

import com.LexiFlash.app.Interfaces.Playable;
import com.LexiFlash.app.Level.Level;

public class GamePlayer implements Playable<Game,Boolean>{

    Level[] levels;

    @Override
    public Boolean play(Game game) {

        this.levels = game.levels;

        while (true) {

            String options[] = {"Play", "Edit"};
            Integer option = GameUI.menu(options);

            Integer selectedLevel;

            switch (option) {
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                case 1:
                    selectedLevel = indexLevels();
                    if(selectedLevel == 0)
                        break;
                    game.levels[selectedLevel - 1].play();
                    break;
                case 2:
                    //TODO: Add remove and add level options to the index
                    // If one of those options is selected, call the respective method
                    selectedLevel = indexLevels();
                    if(selectedLevel == 0)
                        break;
                    game.levels[selectedLevel - 1].edit();
                default:
                    break;
            }            
        }
    }

    Integer indexLevels() {
        String[] options = new String[this.levels.length];
        for (int i = 0; i < this.levels.length; i++) {
            options[i] = this.levels[i].getAsOption();
        }

        int option = GameUI.menu(options);

        GameUI.clearConsole();

        return option;
}
    
}
