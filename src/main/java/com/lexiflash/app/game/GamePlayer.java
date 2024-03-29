package com.lexiflash.app.game;

import com.lexiflash.app.interfaces.Playable;
import com.lexiflash.app.level.Level;

public class GamePlayer implements Playable<Game,Boolean>{

    @Override
    public Boolean play(Game game) {
        boolean playing = true;
        while (playing) {

            GameUI.clearConsole();

            String[] options = {"Play", "Edit"};
            Integer option = GameUI.menu(options);

            Integer selectedLevel;

            switch (option) {
                case 0:
                    System.out.println("Goodbye!");
                    playing = false;
                    break;
                case 1:
                    selectedLevel = indexLevels();
                    if(selectedLevel == 0)
                        break;
                    game.levels[selectedLevel - 1].play();
                    break;
                case 2:
                    selectedLevel = indexLevels(true);
                    if(selectedLevel == 0)
                        break;
                    if(selectedLevel == 1)
                        game.addLevel(Level.createLevel());
                    else
                        game.levels[selectedLevel - 2].edit();
                    break;
                default:
                    break;
            }            
        }
        System.exit(0);
        return true;
    }

    Integer indexLevels() {
        return indexLevels(false);
    }

    Integer indexLevels(Boolean edit) {
        String[] options;
        
        Game game = Game.getInstance();

        if(Boolean.TRUE.equals(edit)) {
            options = new String[game.levels.length + 1];
            options[0] = "Add new level";
        } else {
            options = new String[game.levels.length];
        }

        for (int i = 0; i < game.levels.length; i++) {
            if(Boolean.TRUE.equals(edit)) {
                options[i + 1] = game.levels[i].getAsOption();
            } else {
                options[i] = game.levels[i].getAsOption();
            }
        }

        int option = GameUI.menu(options);

        GameUI.clearConsole();

        return option;
}
    
}
