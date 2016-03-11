package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Charles Siebert on 3/9/2016.
 */
public class Player implements Serializable {
    public int betValue;
    public int walletValue;
    public void hit(){

    }

    public void bet(double betAmount) {
    betValue += betAmount;
        walletValue -= betAmount;
    }
    public void win() {
        betValue = 0;
        walletValue -= betValue;
    }
    public void lose() {
        betValue = 0;
        walletValue += betValue;
        walletValue += betValue;
    }
    public void doublebet() {
        betValue += betValue;
    }
    public void split() {

    }

    public void stand() {

    }
    public Player() {
        betValue = 0;
        walletValue = 200;
    }
    public int getMoney() {
        return walletValue;
    }
}
