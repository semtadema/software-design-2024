package com.lexiflash.app.card;

import com.lexiflash.app.game.GameUI;
import com.lexiflash.app.interfaces.Printable;

public class CardUI implements Printable<Card> {
    public void print(Card card) {
        String edge = "+------------------------------+";
        System.out.println(GameUI.BLUE + edge);
        String emptyRow = "|                              |";
        System.out.println(emptyRow);
        String fromWordRow = "|       From: " + card.getFromWord() + " ".repeat(30-card.getFromWord().length()-13) + "|";
        System.out.println(fromWordRow);
        String toWordRow = "|       To: " + card.getToWord() + " ".repeat(30-card.getToWord().length()-11) + "|";
        System.out.println(toWordRow);
        System.out.println(emptyRow);
        System.out.println(edge + GameUI.RESET);

    }
}
