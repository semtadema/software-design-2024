package com.LexiFlash.app.Game;

public class Helper {

    public static void saveGame() {
        Game game = Game.getInstance();
        game.saveGame();
    }

}
