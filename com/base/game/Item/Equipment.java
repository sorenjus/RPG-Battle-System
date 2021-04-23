package com.base.game.Item;

import com.base.game.gameobjects.Inventory;

/**
 * Class handles currently equipped items
 *
 * @author Adrian Croitoru
 */
public class Equipment {
    /**
     * Array of which items cam be equipped
     */
    private EquippableItems[] equippableItems;
    /**
     * The player's inventory
     */
    private Inventory inventory;

    /**
     * Constructor for a new set of equipment
     *
     * @param inventory The player's inventory
     */
    public Equipment(Inventory inventory) {
        equippableItems= new EquippableItems[EquippableItems.NUM_SLOTS];
        this.inventory = inventory;
    }

    /**
     * Equips an item
     *
     * @param item The item being equipped
     * @return Whether the item was successfully equipped
     */
    public boolean equipItem(EquippableItems item) {
        int index = item.getSlot();

        if (equippableItems[index] != null) {
            if(!deEquipItem(index))
                return false;
        }

        inventory.dropItem(item);
        equippableItems[index] = item;
        return true;
    }

    /**
     * Unequips an equipped item
     *
     * @param slot The location of the item to unequip
     * @return Whether the item was successfully unequipped
     */
    public boolean deEquipItem(int slot) {
        if(inventory.addItemToInventory(equippableItems[slot])) {
            equippableItems[slot] = null;
            return true;
        }
        return false;
    }
}
