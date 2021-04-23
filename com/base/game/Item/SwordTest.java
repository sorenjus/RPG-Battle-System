package com.base.game.Item;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SwordTest {

    @Test
    public void swordTestOne() {

        final Sword swordTest = new Sword(60, 66);
        assertEquals(31, swordTest.getItemRange());
        assertEquals(2, swordTest.getStrIncrease());
        assertEquals(60,swordTest.getX());
        assertEquals(66,swordTest.getY());
        assertEquals("Sword",swordTest.itemName);
        assertEquals("1", swordTest.getTypeItem());
    }

    @Test
    public void swordTestTwo() {

        final Sword swordTest = new Sword(-10, -11);
        assertEquals(31, swordTest.getItemRange());
        assertEquals(2, swordTest.getStrIncrease());
        assertEquals(-10,swordTest.getX());
        assertEquals(-11,swordTest.getY());
        assertEquals("Sword",swordTest.itemName);
        assertEquals("1", swordTest.getTypeItem());
    }

    @Test
    public void  swordTestThree() {

        final Sword swordTest = new Sword(798, 987);
        assertEquals(31, swordTest.getItemRange());
        assertEquals(2, swordTest.getStrIncrease());
        assertEquals(798,swordTest.getX());
        assertEquals(987,swordTest.getY());
        assertEquals("Sword",swordTest.itemName);
        assertEquals("1", swordTest.getTypeItem());
    }
}