package com.base.game.item;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for a Sword that can be equipped and used
 *
 * @author Adrian Croitoru
 */
public class EquippableItemsTest {
    //Create new equippable item to test
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
        final int slot = eitem.getSlot();
        assertEquals(1, slot);
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