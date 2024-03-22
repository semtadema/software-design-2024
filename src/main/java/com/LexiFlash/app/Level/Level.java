package com.LexiFlash.app.Level;

import com.LexiFlash.app.Deck.Deck;

public class Level {

    public String id;
    public String name;
    public String label;
    public String fromLanguage;
    public String toLanguage;
    public Deck deck;
    public boolean badge;

    LevelUI levelUI = new LevelUI();
    LevelManager levelManager = new LevelManager();
    LevelPlayer levelPlayer = new LevelPlayer();


    public Level(String id, String name, String label, String fromLanguage, String toLanguage, Deck deck, boolean badge) {
        this.id = id;
        this.name = name;
        this.label = label;
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
        this.deck = deck;
        this.badge = badge;
    }

    public void print() {
        levelUI.print(this);
    }

    public void play() {
        levelPlayer.play(this);
    }

    public void edit() {
        levelManager.edit(this);
    }

    public String getAsOption() {
        if(this.badge) {
            return this.label + "       Badge achieved";
        } else {
            return this.label + "       Badge not achieved";
        }        
    }

}
