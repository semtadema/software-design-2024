package com.LexiFlash.app.Level;

import com.LexiFlash.app.Interfaces.Printable;

public class LevelUI implements Printable<Level> {

    @Override
    public void print(Level level) {
        System.out.println("Level: " + level.getName() + " - " + level.getLabel());
        System.out.println("From: " + level.getFromLanguage() + " - To: " + level.getToLanguage());
        System.out.println("Total Cards: " + level.getDeck().getCards().length);
        level.getDeck().print();
        System.out.println();
        System.out.println();
    }
    
}
