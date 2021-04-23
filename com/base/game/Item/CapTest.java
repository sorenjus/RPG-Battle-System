package com.base.game.Item;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

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