package com.base.game.item;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for a Sword that can be equipped and used
 *
 * @author Adrian Croitoru
 */
public class CapTest {

    @Test
    public void capTestOne() {

        final Cap newCap = new Cap(150, 150);
            assertEquals(1, newCap.getDefense());
            assertEquals(150,newCap.getX());
            assertEquals(150,newCap.getY());
            assertEquals("Cap",newCap.itemName);
            assertEquals("1", newCap.getTypeItem());
    }

    @Test
    public void capTestTwo() {

        final Cap newCap = new Cap(0, 150);
        assertEquals(1, newCap.getDefense());
        assertEquals(0,newCap.getX());
        assertEquals(150,newCap.getY());
        assertEquals("Cap",newCap.itemName);
        assertEquals("1", newCap.getTypeItem());
    }

    @Test
    public void capTestThree() {

        final Cap newCap = new Cap(500, 600);
        assertEquals(1, newCap.getDefense());
        assertEquals(500,newCap.getX());
        assertEquals(600,newCap.getY());
        assertEquals("Cap",newCap.itemName);
        assertEquals("1", newCap.getTypeItem());
    }

}