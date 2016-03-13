package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Game {
    public boolean error;
    public Dealer newDealer;
    public Player newPlayer;

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();


    public Game() {
        newPlayer = new Player();
        newDealer = new Dealer();
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        buildDeck();
        shuffle();
        dealTwo();
        error = false;
    }

    //Now counting from aces (one) and up to 13 being kings
    public void buildDeck() {
        for (int i = 1; i < 14; i++) {
            deck.add(new Card(i, Suit.Clubs));
            deck.add(new Card(i, Suit.Hearts));
            deck.add(new Card(i, Suit.Diamonds));
            deck.add(new Card(i, Suit.Spades));
        }
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public void dealTwo() {
        for (int i = 0; i < 2; i++) {
            cols.get(i).add(deck.get(deck.size() - 1));
            deck.remove(deck.size() - 1);
        }
    }

    public void dealOne() {
        cols.get(0).add(deck.get(deck.size() - 1));
        deck.remove(deck.size() - 1);
    }

    public void resolveGame() {
        int i = 5;
        while (i < newDealer.hitLimit) {
            cols.get(1).add(deck.get(deck.size() - 1));
            deck.remove(deck.size() - 1);
            i += 5;
        }
    }

    public int currentHand() {
        return currentHand() + 5;
    }
}