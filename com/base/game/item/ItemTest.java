package com.base.game.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for a Sword that can be equipped and used
 *
 * @author Adrian Croitoru
 */
public class ItemTest {

    /**
     *  create new item to test
     */

    Item testItem = new Item();
    /**
     *  testName for an item
     */

    String testName = "Cruel Stick of DOOM";

    @Test
    @Order(1)
    void init() {
        testItem.init(25,35, 0.1f, 0.2f,0.3f,32,64);
        assertEquals(25, testItem.getX());
        assertEquals(35, testItem.getY());
        assertEquals(32, testItem.getSizeX());
        assertEquals(64, testItem.getSizeY());
    }

    @Test
    @Order(2)
    void setItemName() {
        testItem.setItemName(testName);
        assertEquals(testName, (testItem.getItemName()));
    }
}