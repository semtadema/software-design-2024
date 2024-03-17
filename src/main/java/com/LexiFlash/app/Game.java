package com.LexiFlash.app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    @SuppressWarnings("unchecked")
    private void getGameFile() {
        try {

            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("game.json");

            Object jsonObj = parser.parse(reader);

            JSONObject jsonObject = (JSONObject) jsonObj;

            JSONArray levels = (JSONArray) jsonObject.get("levels");

            for (Object level : levels) {
                JSONObject levelObject = (JSONObject) level;

                String id = (String) levelObject.get("id");

                if(id == null) {
                    id = java.util.UUID.randomUUID().toString();
                    levelObject.put("id", id);
                }

                String name = (String) levelObject.get("name");
                String label = (String) levelObject.get("label");
                String fromLanguage = (String) levelObject.get("fromLanguage");
                String toLanguage = (String) levelObject.get("toLanguage");
                boolean badge = (boolean) levelObject.get("badge");

                JSONArray cards = (JSONArray) levelObject.get("cards");

                Card[] cardArray = new Card[cards.size()];

                for (int i = 0; i < cards.size(); i++) {
                    JSONObject card = (JSONObject) cards.get(i);

                    String cardId = (String) card.get("id");

                    if(cardId == null) {
                        cardId = java.util.UUID.randomUUID().toString();
                        card.put("id", cardId);
                    }

                    String fromWord = (String) card.get("fromWord");
                    String toWord = (String) card.get("toWord");
                    String fromHint = (String) card.get("fromHint");
                    String toMeaning = (String) card.get("toMeaning");
                    boolean solved = (boolean) card.get("solved");

                    cardArray[i] = new Card(cardId, fromWord, toWord, fromHint, toMeaning, solved);
                }

                Deck deck = new Deck(cardArray);

                Level levelObj = new Level(id, name, label, fromLanguage, toLanguage, deck, badge);

                if (this.levels == null) {
                    this.levels = new Level[1];
                    this.levels[0] = levelObj;
                } else {
                    Level[] temp = new Level[this.levels.length + 1];
                    for (int i = 0; i < this.levels.length; i++) {
                        temp[i] = this.levels[i];
                    }
                    temp[this.levels.length] = levelObj;
                    this.levels = temp;
                }

                //Save the game file
                saveGame();

            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.exit(1);
        }
    }

    public void saveGame() {


        //Save the game file
        try (FileWriter file = new FileWriter("game.json")) {
            file.write(this.toJsonObject().toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();

        JSONArray levels = new JSONArray();

        for (Level level : this.levels) {
            JSONObject levelObject = new JSONObject();
            levelObject.put("id", level.getId());
            levelObject.put("name", level.getName());
            levelObject.put("label", level.getLabel());
            levelObject.put("fromLanguage", level.getFromLanguage());
            levelObject.put("toLanguage", level.getToLanguage());
            levelObject.put("badge", level.getBadge());

            JSONArray cards = new JSONArray();

            for (Card card : level.getDeck().getCards()) {
                JSONObject cardObject = new JSONObject();
                cardObject.put("id", card.getId());
                cardObject.put("fromWord", card.getFromWord());
                cardObject.put("toWord", card.getToWord());
                cardObject.put("fromHint", card.getFromHint());
                cardObject.put("toMeaning", card.getToMeaning());
                cardObject.put("solved", card.getSolved());

                cards.add(cardObject);
            }

            levelObject.put("cards", cards);

            levels.add(levelObject);
        }

        jsonObject.put("levels", levels);

        return jsonObject;
    }

    public void print() {
        for (Level level : levels) {
            level.print();
        }
    }

    public void play() {
        while (true) {

            String options[] = {"Play", "Edit"};
            Integer option = Helper.menu(options);

            Integer selectedLevel;

            switch (option) {
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                case 1:
                    selectedLevel = indexLevels();
                    if(selectedLevel == 0)
                        break;
                    this.levels[selectedLevel - 1].play();
                    break;
                case 2:
                    selectedLevel = indexLevels();
                    if(selectedLevel == 0)
                        break;
                    this.levels[selectedLevel - 1].edit();
                default:
                    break;
            }

            
        }
    }

    private Integer indexLevels() {
            String[] options = new String[this.levels.length];
            for (int i = 0; i < this.levels.length; i++) {
                options[i] = this.levels[i].getAsOption();
            }

            int option = Helper.menu(options);

            Helper.clearConsole();

            return option;
    }
}
