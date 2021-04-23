package com.base.game.Item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {


    Item item = new Item();
    String testName = "Cruel Stick of DOOM";

    @Test
    @Order(1)
    void init() {
        item.init(25,35, 0.1f, 0.2f,0.3f,32,64);
        assertEquals(25, item.getX());
        assertEquals(35,item.getY());
        assertEquals(32,item.getSizeX());
        assertEquals(64,item.getSizeY());
    }

    @Test
    @Order(2)
    void setItemName() {
        item.setItemName(testName);
        assertEquals(testName, (item.getItemName()));
    }
}