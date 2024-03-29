package com.lexiflash.app.level;

import com.lexiflash.app.deck.DeckResults;
import com.lexiflash.app.game.GameManager;
import com.lexiflash.app.game.GameUI;
import com.lexiflash.app.interfaces.Playable;

public class LevelPlayer implements Playable<Level,Boolean> {

    @Override
    public Boolean play(Level level) {
        
        System.out.print("Playing level... ");
        GameUI.sleep(1);
        System.out.println(level.getLabel());
        GameUI.sleep(1);
        GameUI.clearConsole();

        DeckResults results = level.getDeck().play();

        level.setBadge(results.getReceivedBadge());

        //Save the level
        GameManager.saveLevel(level);

        results.print();

        System.out.println("Press enter to continue...");
        System.console().readLine();
        
        GameUI.clearConsole();

        return results.getReceivedBadge();
    }
    
}
