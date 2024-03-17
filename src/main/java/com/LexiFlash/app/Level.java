package com.LexiFlash.app;

import java.util.Scanner;

import javax.swing.event.ChangeListener;

public class Level {

    private String id;
    private String name;
    private String label;
    private String fromLanguage;
    private String toLanguage;
    private Deck deck;
    private boolean badge;

    public Level(String id, String name, String label, String fromLanguage, String toLanguage, Deck deck, boolean badge) {
        this.id = id;
        this.name = name;
        this.label = label;
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
        this.deck = deck;
        this.badge = badge;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getFromLanguage() {
        return fromLanguage;
    }

    public String getToLanguage() {
        return toLanguage;
    }

    public Deck getDeck () {
        return deck;
    }

    public boolean getBadge() {
        return badge;
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

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setBadge(boolean badge) {
        this.badge = badge;
    }

    public void print() {
        System.out.println("Level: " + name + " - " + label);
        System.out.println("From: " + fromLanguage + " - To: " + toLanguage);
        System.out.println("Total Cards: " + deck.length);
        deck.print();
        System.out.println();
        System.out.println();
    }

    public void play() {
        System.out.print("Playing level... ");
        Helper.sleep(1);
        System.out.println(this.label);
        Helper.sleep(1);
        Helper.clearConsole();

        DeckResults results = this.deck.play();

        this.badge = results.receivedBadge;

        Helper.saveGame();

        results.print();

        System.out.println("Press enter to continue...");
        System.console().readLine();
        
        Helper.clearConsole();


    }

    public void edit() {
        System.out.println("Editing level... " + this.label);
        //Options to edit properties of the level
        String[] options = {"Name: " + this.name, "Label: " + this.label, "From Language: " + this.fromLanguage, "To Language: " + this.toLanguage, "Deck"};

        Integer option = Helper.menu(options, "Choose a property to edit: ");

        switch (option) {
            case 1:
                System.out.println("Enter the new name: ");
                this.name = System.console().readLine();
                break;
            case 2:
                System.out.println("Enter the new label: ");
                this.label = System.console().readLine();
                break;
            case 3:
                System.out.println("Enter the new from language: ");
                this.fromLanguage = System.console().readLine();
                break;
            case 4:
                System.out.println("Enter the new to language: ");
                this.toLanguage = System.console().readLine();
                break;
            case 5:
                this.deck.edit();
                break;
            default:
                break;
        }

        Helper.saveGame();
    }

    public String getAsOption() {

        if(this.badge) {
            return this.label + "       Badge achieved";
        } else {
            return this.label + "       Badge not achieved";
        }

        
    }

}
