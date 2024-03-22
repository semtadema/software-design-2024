package com.LexiFlash.app.Game;
import com.LexiFlash.app.Level.Level;

public class Game {

    private static Game INSTANCE;
    Level[] levels;

    GamePlayer gamePlayer = new GamePlayer();
    GameUI gameUI = new GameUI();

    GameManager gameManager = new GameManager();

    private Game() {
        gameManager.getGameFile(this);
    }

    public static void main(String[] args)
    {
        Game game = Game.getInstance();

        try {
            game.play();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Game getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Game();
        }

        return INSTANCE;
    }

    public void print() {
        gameUI.print(this);
    }

    public void play() {
        gamePlayer.play(this);
    }

    public void saveGame() {
        gameManager.saveGame(this);
    }

}
