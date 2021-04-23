package com.base.game.Item;

import com.base.game.gameobjects.Inventory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for a Sword that can be equipped and used
 *
 * @author Adrian Croitoru
 */
public class EquipmentTest {


    @Test
    public void equipmentTestOne()
    {
        Inventory inv = new Inventory(5);

        //create 9 items, 4 to equip in 4 slots and 5 to store in inventory to make it full
        EquippableItems eitem0 = new EquippableItems();
        EquippableItems eitem1 = new EquippableItems();
        EquippableItems eitem2 = new EquippableItems();
        EquippableItems eitem3 = new EquippableItems();
        EquippableItems eitem00 = new EquippableItems();
        EquippableItems eitem11 = new EquippableItems();
        EquippableItems eitem22 = new EquippableItems();
        EquippableItems eitem33 = new EquippableItems();
        EquippableItems eitem44 = new EquippableItems();
        eitem0.init(15,15,0.1f,0.2f,0.4f,32,32,0);
        eitem1.init(30,30,0.1f,0.2f,0.4f,32,32,1);
        eitem2.init(44,44,0.1f,0.2f,0.4f,32,32,2);
        eitem3.init(55,55,0.1f,0.2f,0.4f,32,32,3);
        eitem00.init(66,66,0.1f,0.2f,0.4f,32,32,0);
        eitem11.init(66,66,0.1f,0.2f,0.4f,32,32,1);
        eitem22.init(66,66,0.1f,0.2f,0.4f,32,32,1);
        eitem33.init(66,66,0.1f,0.2f,0.4f,32,32,1);
        eitem44.init(66,66,0.1f,0.2f,0.4f,32,32,1);


        //add 5 items to inventory (inventory is full now)
        inv.addItemToInventory(eitem0);
        inv.addItemToInventory(eitem1);
        inv.addItemToInventory(eitem2);
        inv.addItemToInventory(eitem3);
        inv.addItemToInventory(eitem00);
        Equipment equipment = new Equipment(inv);

        //equip 4 of them in 4 different slots, equip another one in a slot, the item is unequipped and placed in inventory
        //we have 4 items equipped, 1 in inventory
        assertTrue(equipment.equipItem(eitem0));
        assertTrue(equipment.equipItem(eitem1));
        assertTrue(equipment.equipItem(eitem2));
        assertTrue(equipment.equipItem(eitem3));
        assertTrue(equipment.equipItem(eitem00));
        //add 1 more item to inventory, and equip it
        //now have 4 items equipped and 2 in inventory
        inv.addItemToInventory(eitem11);
        assertTrue(equipment.equipItem(eitem11));
        //add 1 more item to inventory, and equip it
        //now have 4 items equipped and 3 in inventory
        inv.addItemToInventory(eitem22);
        assertTrue(equipment.equipItem(eitem22));
        //add 1 more item to inventory, and equip it
        //now have 4 items equipped and 4 in inventory
        inv.addItemToInventory(eitem33);
        assertTrue(equipment.equipItem(eitem33));
        //add 1 more item to inventory, inventory is now at 5 and equipped items at 4 (inventory is full
        //try equipping item, can't equip as we have no room in inventory to switch items.
        inv.addItemToInventory(eitem44);
        assertFalse(equipment.equipItem(eitem44)); // inventory is full, can't equip item as we don't have space to unequip items


    }

}