package com.LexiFlash.app;

public class Card {

    private String id;
    private String fromWord;
    private String toWord;
    private String fromHint;
    private String toMeaning;
    private boolean solved;

    public Card(String id, String fromWord, String toWord, String fromHint, String toMeaning, boolean solved) {
        this.id = id;
        this.fromWord = fromWord;
        this.toWord = toWord;
        this.fromHint = fromHint;
        this.toMeaning = toMeaning;
        this.solved = solved;
    }

    public String getId() {
        return id;
    }

    public String getFromWord() {
        return fromWord;
    }

    public String getToWord() {
        return toWord;
    }

    public String getFromHint() {
        return fromHint;
    }

    public String getToMeaning() {
        return toMeaning;
    }

    public boolean getSolved() {
        return solved;
    }

    public void setFromWord(String fromWord) {
        this.fromWord = fromWord;
    }

    public void setToWord(String toWord) {
        this.toWord = toWord;
    }

    public void setFromHint(String fromHint) {
        this.fromHint = fromHint;
    }

    public void setToMeaning(String toMeaning) {
        this.toMeaning = toMeaning;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public void print() {
        System.out.println("From: " + fromWord + " - To: " + toWord);
        System.out.println("Hint: " + fromHint + " - Meaning: " + toMeaning);
        System.out.println("Solved: " + solved);
    }

    public boolean play() {
        
        System.out.println("Bla bla: " + fromWord);
        System.out.println("What is the correct translation: ");
        String answer = System.console().readLine();

        if(answer.equals(toWord)) {
            this.solved = true;
            System.out.println("Yay that's correct!");
            Helper.sleep(1);
            Helper.clearConsole();
        } else {
            this.solved = false;
            System.out.println("Oops that's wrong the correct answer is: " + toWord);
            Helper.sleep(2);
            Helper.clearConsole();
        }

        Helper.saveGame();

        return this.solved;
    }

    public String getAsOption() {
        return fromWord + " - " + toWord;
    }

    public static Card createCard() {
        System.out.println("Creating a new card...");
        System.out.println("From: ");
        String fromWord = System.console().readLine();
        System.out.println("To: ");
        String toWord = System.console().readLine();
        System.out.println("Hint: ");
        String fromHint = System.console().readLine();
        System.out.println("Meaning: ");
        String toMeaning = System.console().readLine();
        String id = java.util.UUID.randomUUID().toString();

        return new Card(id, fromWord, toWord, fromHint, toMeaning, false);
    }

    public void edit() {
        System.out.println("Editing card...");
        String[] options = new String[] {"From", "To", "Hint", "Meaning"};

        Integer option = Helper.menu(options, "Choose a property to edit: ");

        switch (option) {
            case 1:
                System.out.println("From: ");
                this.fromWord = System.console().readLine();
                break;
            case 2:
                System.out.println("To: ");
                this.toWord = System.console().readLine();
                break;
            case 3:
                System.out.println("Hint: ");
                this.fromHint = System.console().readLine();
                break;
            case 4:
                System.out.println("Meaning: ");
                this.toMeaning = System.console().readLine();
                break;
        }

        Helper.saveGame();
    }

}
