package com.base.game.Item;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChainMailTest {

    @Test
    public void mailTestOne() {

        final ChainMail newMail = new ChainMail(600, 900);
        assertEquals(3, newMail.getDefense());
        assertEquals(600,newMail.getX());
        assertEquals(900,newMail.getY());
        assertEquals("Chain Mail",newMail.itemName);
        assertEquals("1", newMail.getTypeItem());
    }

    @Test
    public void mailTestTwo() {

        final ChainMail newMail = new ChainMail(-100, -150);
        assertEquals(3, newMail.getDefense());
        assertEquals(-100,newMail.getX());
        assertEquals(-150,newMail.getY());
        assertEquals("Chain Mail",newMail.itemName);
        assertEquals("1", newMail.getTypeItem());
    }

    @Test
    public void mailTestThree() {

        final ChainMail newMail = new ChainMail(5000, 6000);
        assertEquals(3, newMail.getDefense());
        assertEquals(5000,newMail.getX());
        assertEquals(6000,newMail.getY());
        assertEquals("Chain Mail",newMail.itemName);
        assertEquals("1", newMail.getTypeItem());
    }

}