package com.lexiflash.app.game;

import com.lexiflash.app.interfaces.Printable;
import com.lexiflash.app.level.Level;

public class GameUI implements Printable<Game> {
    public static final String RESET = "\033[0m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String RED = "\033[0;31m";

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
                System.out.println(GameUI.YELLOW + message + GameUI.RESET);
            } else {
                System.out.println(GameUI.YELLOW + "Choose an option:" + GameUI.RESET);
            }
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ": " + options[i]);
            }
            System.out.println("0: Exit");
            System.out.print(GameUI.YELLOW + "Select option: " + GameUI.RESET);

            Integer option = Integer.parseInt(System.console().readLine());

            if (option < 0 || option > options.length) {
                System.out.println(GameUI.RED + "Invalid option" + GameUI.RESET);
                clearConsole();
                return menu(options, message);
            }

            clearConsole();

            return option;
        } catch (Exception ex) {
            System.out.println(GameUI.RED + "Invalid option" + GameUI.RESET);
            clearConsole();
            return menu(options, message);
        }
    }

    public static final void clearConsole() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (final Exception e) {
            // Handle any exceptions.
        }
    }

    public static final void sleep(Integer sec) {
        // Sleep
        try {
            Thread.sleep((long) sec * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

}
