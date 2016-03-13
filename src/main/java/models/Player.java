package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charles Siebert on 3/9/2016.
 */
public class Player extends basePlayer {

    public java.util.List<Card> playerHand;

    public Player() {
        playerHand = new ArrayList<>();
    }
    public void hit(List<Card> deck) {
        playerHand.add(deck.get(deck.size()-1));
        deck.remove(deck.size()-1);

    }
    public void stay() {
        //end player turn, resolve dealer's turn.
        //resolveGame();

    }
}
