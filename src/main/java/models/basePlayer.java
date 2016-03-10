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



}
