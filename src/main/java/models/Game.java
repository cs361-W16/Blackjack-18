package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    //player hit function
    public void dealOne() {
        cols.get(0).add(deck.get(deck.size() - 1));
        deck.remove(deck.size() - 1);
    }

    //deals out the rest of the cards to the dealer, if they are below 17
    public void resolveGame() {
        if (newPlayer.stay()) {
            while (currentHand(cols.get(1)) < newDealer.hitLimit) {
                cols.get(1).add(deck.get(deck.size() - 1));
                deck.remove(deck.size() - 1);
            }
        }
    }

    //elegant way of handling this
    //http://stackoverflow.com/questions/837951/is-there-an-elegant-way-to-deal-with-the-ace-in-blackjack
    public int currentHand(List<Card> hand) {
        int i;
        int handValue = 0;
        int cardValue;
        int numAces = 0;

        for ( i = 0; i < hand.size(); i++ ) {
            cardValue = hand.get(i).getValue();

            //we count up how many aces we have
            if(cardValue == 1) {
                numAces += 1;
                cardValue = 11;
            }
            //reduce the value of face cards
            else if(cardValue >= 11) {
                cardValue = 10;
            }
            handValue += cardValue;
        }
        //subtract for each ace that would put us over 21.
        if( handValue > 21 ) {
            for( i = 0; i < numAces; i++ ) {
                handValue -= 10;
            }
        }
        return handValue;
    }
}