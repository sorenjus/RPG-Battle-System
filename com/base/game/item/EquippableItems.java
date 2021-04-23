package com.base.game.item;

import com.base.engine.Sprite;

/**
 * Class for items that can be equipped by the player
 */
public class EquippableItems extends Item {
    /**
     * The number of items that can be equipped at a time
     */
    public static final int NUM_SLOTS = 4;

    /**
     * Numeric values for different slots where items can be equipped
     */
    public static final int WEAPON_SLOT = 0;
    public static final int HEAD_SLOT = 1;
    public static final int ARMOR_SLOT = 2;
    public static final int LEG_SLOT = 3;

    /**
     * The slot an item is being equipped to
     */
    private int slot;

    /**
     * Initializes a new equippaable item
     *
     * @param xCord Horizontal position
     * @param yCord Vertical position
     * @param red Red value of sprite
     * @param green Green value of sprite
     * @param blue Blue value of sprite
     * @param hLength Horizontal length
     * @param vLength Vertical length
     * @param slot Slot number being equipped to
     */
    public void init(final float xCord, final float yCord, final float red, final float green, final float blue,
                     final float hLength, final float vLength, final int slot) {
        this.xCoordinate = xCord;
        this.yCoordinate = yCord;
        this.slot = slot;
        this.sprite = new Sprite(red, green, blue, hLength, vLength);

    }

    /**
     * Returns the current slot
     *
     * @return Current slot
     */
    public int getSlot() {
        return slot;
    }
}
