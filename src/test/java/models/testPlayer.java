package models;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Charles Siebert on 3/13/2016.
 */
public class testPlayer {

    @Test
    public void testPlayerStay() {
        Player p = new Player();
        assertTrue(p.stay());
    }

    @Test
    public void testDealerLimit() {
        Dealer d = new Dealer();
        assertEquals(17, d.hitLimit);
    }
}