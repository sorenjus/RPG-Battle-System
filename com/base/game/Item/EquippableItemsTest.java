package com.base.game.Item;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EquippableItemsTest {

    EquippableItems eitem = new EquippableItems();

    @Test
    public void equipTestOne()
    {
        eitem.init(55,66,1f,0.1f,0.5f, 64,32,0);
        assertEquals(0, eitem.getSlot());
        assertEquals(55, eitem.getX());
        assertEquals(66,eitem.getY());
        assertEquals(64,eitem.getSizeX());
        assertEquals(32,eitem.getSizeY());
    }

    @Test
    public void equipTestTwo()
    {
        eitem.init(22,11,0f,0.1f,0.1f, -32,32,1);
        int i = eitem.getSlot();
        assertEquals(1, i);
        assertEquals(22, eitem.getX());
        assertEquals(11,eitem.getY());
        assertEquals(-32,eitem.getSizeX());
        assertEquals(32,eitem.getSizeY());
    }

    @Test
    public void equipTestThree()
    {
        eitem.init(9,1,0f,00f,000f, 5,2,3);
        assertEquals(3, eitem.getSlot());
        assertEquals(9, eitem.getX());
        assertEquals(1,eitem.getY());
        assertEquals(5,eitem.getSizeX());
        assertEquals(2,eitem.getSizeY());
    }

    @Test
    public void equipTestFour()
    {
        eitem.init(55,66,1f,0.1f,0.5f, 64,32,4);
        assertEquals(4, eitem.getSlot());
        assertEquals(55, eitem.getX());
        assertEquals(66,eitem.getY());
        assertEquals(64,eitem.getSizeX());
        assertEquals(32,eitem.getSizeY());
    }


}