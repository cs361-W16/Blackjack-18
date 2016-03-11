package models;

import java.util.ArrayList;
/**
 * Created by Charles Siebert on 3/9/2016.
 */
public class basePlayer {

    public String name;

    public java.util.List<Card> hand = new ArrayList<>();

    //abstract method
    public void hit() {}

    public int currentHand() {
        //return hand count, including Aces logic
        return 0;
    }

    public boolean ifBusted() {
        if (currentHand() > 21 ) {
            return true; //we busted
        } else
            return false; //nope.jpg
    }

}
