package classes;
import java.util.Scanner;

import interfaces.Playable;

public class Game implements Playable{

    protected Scanner scanner;
    protected String filePath;
    protected static final String[] OPTIONS = {"Play", "Edit", "Get certificate", "Quit"};


    public Game(String filePath) {
        this.filePath = filePath;
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        System.out.println("MENU");
        for (int i = 0; i < OPTIONS.length; i++) {
            String option = OPTIONS[i];
            System.out.println((i + 1) + ": " + option);
        }
        System.out.print("Select an option: ");
        String selectedOption = scanner.nextLine();

        App.clearConsole();

        switch (selectedOption) {
            case "1":
                System.out.println("We're playing");
                break;
            case "2":
                System.out.println("We're editing");
                break;
            case "3":
                System.out.println("We're printing");
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public void play() {
        System.out.println("Welcome to LingoLeap.");
        System.out.println("This game is best played in fullscreen.");
        
        // For estatic purposes
        App.loading();
        App.clearConsole();

        while(true) {
            menu();
        }        
    }
    
}
