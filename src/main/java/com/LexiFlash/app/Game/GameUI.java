package com.LexiFlash.app.Game;

import com.LexiFlash.app.Interfaces.Printable;
import com.LexiFlash.app.Level.Level;

public class GameUI implements Printable<Game> {

    @Override
    public void print(Game game) {
        for (Level level : game.levels) {
            level.print();
        }
    }

    public static Integer menu(String[] options) {
        return menu(options, null);
    }

    public static Integer menu(String[] options, String message) {
        try {
            if (message != null) {
                System.out.println(message);
            } else {
                System.out.println("Choose an option:");
            }
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ": " + options[i]);
            }
            System.out.println("0: Exit");
            System.out.print("Select option: ");

            Integer option = Integer.parseInt(System.console().readLine());

            if (option < 0 || option > options.length) {
                System.out.println("Invalid option");
                clearConsole();
                return menu(options, message);
            }

            clearConsole();

            return option;
        } catch (Exception ex) {
            System.out.println("Invalid option");
            clearConsole();
            return menu(options, message);
        }
    }

    public final static void clearConsole() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (final Exception e) {
            // Handle any exceptions.
        }
    }

    public final static void sleep(Integer sec) {
        // Sleep
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
