package com.LexiFlash.app.Game;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.LexiFlash.app.Card.Card;
import com.LexiFlash.app.Deck.Deck;
import com.LexiFlash.app.Level.Level;

public class GameManager {

    @SuppressWarnings("unchecked")
    void getGameFile(Game game) {
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

                if (game.levels == null) {
                    game.levels = new Level[1];
                    game.levels[0] = levelObj;
                } else {
                    Level[] temp = new Level[game.levels.length + 1];
                    System.arraycopy(game.levels, 0, temp, 0, game.levels.length);
                    temp[game.levels.length] = levelObj;
                    game.levels = temp;
                }

                //Save the game file
                saveGame(game);

            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.exit(1);
        }
    }

    void saveGame(Game game) {
        //Save the game file
        try (FileWriter file = new FileWriter("game.json")) {
            file.write(toJsonObject(game).toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private JSONObject toJsonObject(Game game) {
        JSONObject jsonObject = new JSONObject();

        JSONArray levels = new JSONArray();

        for (Level level : game.levels) {
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

    public void addLevel(Game game, Object level) {
        if (game.levels == null) {
            game.levels = new Level[1];
            game.levels[0] = (Level) level;
        } else {
            Level[] temp = new Level[game.levels.length + 1];
            System.arraycopy(game.levels, 0, temp, 0, game.levels.length);
            temp[game.levels.length] = (Level) level;
            game.levels = temp;
        }

        saveGame(game);
    }

    public static void removeLevel(Level level) {
        Game game = Game.getInstance();
        
        Level[] temp = new Level[game.levels.length - 1];

        int j = 0;
        for (int i = 0; i < game.levels.length; i++) {
            if (!game.levels[i].getId().equals(level.getId())) {
                temp[j] = game.levels[i];
                j++;
            }
        }

        game.levels = temp;

        game.saveGame();
    }

    public static void saveLevel(Level level) {
        Game game = Game.getInstance();
        
        for (int i = 0; i < game.levels.length; i++) {
            if (game.levels[i].getId().equals(level.getId())) {
                game.levels[i] = level;
            }
        }

        game.saveGame();
    }

    public static void saveCard(Card card) {
        Game game = Game.getInstance();
        
        for (int i = 0; i < game.levels.length; i++) {
            for (int j = 0; j < game.levels[i].getDeck().getCards().length; j++) {
                if (Objects.equals(game.levels[i].getDeck().getCards()[j].getId(), card.getId())) {
                    game.levels[i].getDeck().getCards()[j] = card;
                }
            }
        }

        game.saveGame();
    }
}
