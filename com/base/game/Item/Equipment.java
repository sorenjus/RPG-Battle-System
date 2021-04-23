package com.base.game.Item;

import com.base.game.gameobjects.Inventory;

public class Equipment {

    private EquippableItems[] equippableItems;
    private Inventory inventory;

    public Equipment(Inventory inventory)
    {
        equippableItems= new EquippableItems[EquippableItems.NUM_SLOTS];
        this.inventory = inventory;
    }

    public boolean equipItem(EquippableItems item)
    {
        int index = item.getSlot();

        if (equippableItems[index] != null) {
            if(!deEquipItem(index))
                return false;
        }

        inventory.dropItem(item);
        equippableItems[index] = item;
        return true;
    }

    public boolean deEquipItem(int slot)
    {
        if(inventory.addItemToInventory(equippableItems[slot])) {
            equippableItems[slot] = null;
            return true;
        }
        return false;
    }
}
