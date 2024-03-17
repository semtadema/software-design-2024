package com.LexiFlash.app;

public class App 
{
    public static void main(String[] args)
    {
        Game game = Game.getInstance();

        try {
            game.play();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}