package com.LexiFlash.app.Level;

import com.LexiFlash.app.Interfaces.Printable;

public class LevelUI implements Printable<Level> {

    @Override
    public void print(Level level) {
        System.out.println("Level: " + level.name + " - " + level.label);
        System.out.println("From: " + level.fromLanguage + " - To: " + level.toLanguage);
        System.out.println("Total Cards: " + level.deck.length);
        level.deck.print();
        System.out.println();
        System.out.println();
    }
    
}
