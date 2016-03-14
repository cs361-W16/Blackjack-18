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
    public void hit() {

    }
    public boolean stay() {
        //end player turn, resolve dealer's turn.
       return true;

    }
}
