package com.LexiFlash.app.Level;

import com.LexiFlash.app.Deck.Deck;

public class Level {

    private String id;
    private String name;
    private String label;
    private String fromLanguage;
    private String toLanguage;
    private Deck deck;
    private boolean badge;

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

    public static Level createLevel() {
        LevelManager levelManager = new LevelManager();
        return levelManager.create();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLabel() {
        return this.label;
    }

    public String getFromLanguage() {
        return this.fromLanguage;
    }

    public String getToLanguage() {
        return this.toLanguage;
    }

    public boolean getBadge() {
        return this.badge;
    }
    
    public Deck getDeck() {
        return this.deck;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setFromLanguage(String fromLanguage) {
        this.fromLanguage = fromLanguage;
    }

    public void setToLanguage(String toLanguage) {
        this.toLanguage = toLanguage;
    }

    public void setBadge(boolean receivedBadge) {
        this.badge = receivedBadge;
    }
}
