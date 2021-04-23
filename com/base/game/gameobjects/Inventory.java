package com.base.game.gameobjects;

import com.base.game.Item.Item;

/**
 * A class that manages the player's inventory
 *
 * @author Adrian Croitoru
 */
public class Inventory {
    /**
     * An array of all the Items in the inventory
     */
    private transient final Item[] items;

    /**
     * Creates the player's inventory
     *
     * @param sizeOfInventory The maximum number of items that can be in the inventory
     */
    public Inventory( final int sizeOfInventory)
    {
        this.items = new Item[sizeOfInventory];
    }

    /**
     * Puts a new Item in the inventory
     *
     * @param itemToAdd The Item being added
     * @return Whether the item was successfully added
     */
    public boolean addItemToInventory ( final Item itemToAdd)
    {
        for (int i = 0; i < items.length; i++)
        {
            if(items[i] == null) {
                items[i] = itemToAdd;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns which item is in a certain index in the inventory
     *
     * @param index The index being accessed
     * @return The item in that index
     */
    public Item getItem ( final int index)
    {
        return items[index];
    }

    /**
     * Removes an item from the player's inventory
     *
     * @param itemToDrop The item to get rid of
     * @return Whether the item was successfully dropped
     */
    public boolean dropItem ( final Item itemToDrop)
    {
        for (int i = 0; i<items.length; i++)
        {
            if (items[i]==itemToDrop) {
                items[i] = null;
                return true;
            }
        }
        return false;
    }
}
