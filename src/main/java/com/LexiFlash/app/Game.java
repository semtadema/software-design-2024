package com.LexiFlash.app;

import java.io.FileReader;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Game {

    private static Game INSTANCE;
    private Level[] levels;

    private Game() {
        getGameFile();
    }

    public static Game getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Game();
        }

        return INSTANCE;
    }

    private void getGameFile() {
        try {

            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("game.json");

            Object jsonObj = parser.parse(reader);

            JSONObject jsonObject = (JSONObject) jsonObj;

            JSONArray levels = (JSONArray) jsonObject.get("levels");

            for (Object level : levels) {
                JSONObject levelObject = (JSONObject) level;

                String name = (String) levelObject.get("name");
                String label = (String) levelObject.get("label");
                String fromLanguage = (String) levelObject.get("fromLanguage");
                String toLanguage = (String) levelObject.get("toLanguage");

                JSONArray cards = (JSONArray) levelObject.get("cards");

                Card[] cardArray = new Card[cards.size()];

                for (int i = 0; i < cards.size(); i++) {
                    JSONObject card = (JSONObject) cards.get(i);

                    String fromWord = (String) card.get("fromWord");
                    String toWord = (String) card.get("toWord");
                    String fromHint = (String) card.get("fromHint");
                    String toMeaning = (String) card.get("toMeaning");
                    boolean solved = (boolean) card.get("solved");

                    cardArray[i] = new Card(fromWord, toWord, fromHint, toMeaning, solved);
                }

                Level levelObj = new Level(name, label, fromLanguage, toLanguage, cardArray);

                levelObj.print();

                this.levels = new Level[] { levelObj };
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.exit(1);
        }
    }

}
