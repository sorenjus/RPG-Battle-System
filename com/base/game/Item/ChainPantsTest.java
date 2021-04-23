package com.base.game.Item;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for a Sword that can be equipped and used
 *
 * @author Adrian Croitoru
 */

public class ChainPantsTest {

    @Test
    public void pantsTestOne() {

        final ChainPants newMail = new ChainPants(60, 66);
        assertEquals(2, newMail.getDefense());
        assertEquals(60,newMail.getX());
        assertEquals(66,newMail.getY());
        assertEquals("Chain Mail Pants",newMail.itemName);
        assertEquals("1", newMail.getTypeItem());
    }

    @Test
    public void pantsTestTwo() {

        final ChainPants newMail = new ChainPants(-10, -11);
        assertEquals(2, newMail.getDefense());
        assertEquals(-10,newMail.getX());
        assertEquals(-11,newMail.getY());
        assertEquals("Chain Mail Pants",newMail.itemName);
        assertEquals("1", newMail.getTypeItem());
    }

    @Test
    public void pantsTestThree() {

        final ChainPants newMail = new ChainPants(798, 987);
        assertEquals(2, newMail.getDefense());
        assertEquals(798,newMail.getX());
        assertEquals(987,newMail.getY());
        assertEquals("Chain Mail Pants",newMail.itemName);
        assertEquals("1", newMail.getTypeItem());
    }

}