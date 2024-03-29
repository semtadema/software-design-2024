package com.lexiflash.app.game;
import com.lexiflash.app.level.Level;

public class Game {

    private static Game instance = null;
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
        if (instance == null) {
            instance = new Game();
        }

        return instance;
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

    public void addLevel(Object level) {
        gameManager.addLevel(this, level);
    }

}
