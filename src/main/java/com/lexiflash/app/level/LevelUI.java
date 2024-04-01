package com.lexiflash.app.level;

import com.lexiflash.app.game.GameUI;
import com.lexiflash.app.interfaces.Printable;

public class LevelUI implements Printable<Level> {

    @Override
    public void print(Level level) {
        System.out.println(GameUI.BLUE +"Level: " + level.getName() + " - " + level.getLabel() + GameUI.RESET);
        System.out.println(GameUI.BLUE +"From: " + level.getFromLanguage() + " - To: " + level.getToLanguage() + GameUI.RESET);
        System.out.println(GameUI.BLUE +"Total Cards: " + level.getDeck().getCards().length + GameUI.RESET);
        level.getDeck().print();
        System.out.println();
        System.out.println();
    }
    
}
