package models;


import java.util.ArrayList;

/**
 * Created by Charles Siebert on 3/9/2016.
 */
public class Dealer extends basePlayer {

    public java.util.List<Card> dealerHand;
    int hitLimit=17;

    public Dealer() {
        dealerHand = new ArrayList<>();
    }

    public void stay() {
        //end player turn, resolve dealer's turn.
       // resolveGame();

    }
}
