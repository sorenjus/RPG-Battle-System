package com.base.game.gameobjects;

import com.base.game.Item.Item;

public class Inventory {

    private final Item[] items;

    public Inventory(int sizeOfInventory)
    {
        this.items = new Item[sizeOfInventory];
    }

    public boolean addItemToInventory (Item itemToAdd)
    {
        for (int i = 0; i < items.length; i++)
            if(items[i] == null) {
                items[i] = itemToAdd;
                System.out.println("Picked up a "+ itemToAdd.getItemName() +"!" );
                return true;
            }
        return false;
    }

    public Item getItem (int index)
    {
        return items[index];
    }

    public boolean dropItem (Item itemToDrop)
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
