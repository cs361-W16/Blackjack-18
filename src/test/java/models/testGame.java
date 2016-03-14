package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michaelhilton on 1/25/16.
 */
public class testGame {

    @Test
    public void testGameCreation(){
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game();
        g.buildDeck();
        assertEquals(52,g.deck.size());
    }

    @Test
    public void testGameInit(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        assertNotEquals(2,g.deck.get(0).getValue());
    }

    @Test
    public void testCurrentHand() {
        Game g = new Game();
        g.cols.get(0).add(new Card(1, Suit.Diamonds));
        g.cols.get(0).add(new Card(2, Suit.Diamonds));
        g.cols.get(0).add(new Card(3, Suit.Hearts));
        g.cols.get(0).add(new Card(12, Suit.Diamonds));
        assertEquals(16, g.currentHand(g.cols.get(0)));


    }

    @Test
    public void testGameStart(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealTwo();
        assertEquals(1,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());
    }

    @Test
    public void testNewGame() {
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealTwo();
        assertEquals(1,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());
        g.newGame();
        assertEquals(2,g.cols.get(0).size());
        assertEquals(2,g.cols.get(1).size());

    }

    @Test
    public void testResolveGame() {
        Game g = new Game();
        g.buildDeck();
        g.cols.get(1).add(new Card(9, Suit.Diamonds));
        g.cols.get(1).add(new Card(7, Suit.Diamonds));
        assertEquals(16, g.currentHand(g.cols.get(1)));
        assertEquals(52, g.deck.size());
        g.resolveGame();
        assertEquals(51, g.deck.size());
        assertEquals(3, g.cols.get(1).size());


    }
/*
    @Test
    public void testCustomDeal(){
        Game g = new Game();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        assertEquals("2Clubs",g.cols.get(0).get(0).toString());
        assertEquals("3Clubs",g.cols.get(1).get(0).toString());
        assertEquals("4Clubs",g.cols.get(2).get(0).toString());
        assertEquals("5Clubs",g.cols.get(3).get(0).toString());
    }

    @Test
    public void testRemoveFunction(){
        Game g = new Game();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
    }
*/


}
