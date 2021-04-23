package com.base.game.item;

/**
 * Class for a Sword that can be equipped and used
 *
 * @author Adrian Croitoru
 */
public class Sword extends EquippableItems {
    /**
     * The size of the sword
     */
    public static final float SIZE = 32;

    /**
     * The name of the item
     */
    public static final String ITEMNAME = "Sword";

    /**
     * The increased damage the sword lets the player deal
     */
    private final int STRINCREASE;
    /**
     * The increased the range of the player attack.
     */
    private final int itemRange;

    /**
     * Constructor for a new Sword
     *
     * @param xCoord Horizontal position
     * @param yCoord Vertical position
     */
    public Sword (final float xCoord, final float yCoord){
        init(xCoord, yCoord, 0.1f,0.5f,0.9f, SIZE, SIZE, WEAPON_SLOT);
        this.setItemName(ITEMNAME);
        STRINCREASE = 2;
        this.itemRange =31;
    }

    /**
     * Getter method for the Str increase stat of the weapon
     * @return Str increase of the Item
     */
    public int getStrIncrease()
    {
        return STRINCREASE;
    }

    /**
     * Getter method for the Range Stat stat of the weapon
     * @return Item range of the weapon
     */
    public int getItemRange()
    {
        return itemRange;
    }
}
