package com.base.game.Item;

import com.base.engine.Sprite;

public class EquippableItems extends Item {

    public static final int NUM_SLOTS = 4;
    public static final int WEAPON_SLOT = 0;
    public static final int HEAD_SLOT = 1;
    public static final int ARMOR_SLOT = 2;
    public static final int LEG_SLOT = 3;

    private int slot;


    public void init(final float xCord, final float yCord, final float red, final float green, final float blue, final float hLength, final float vLength, int slot) {
        this.xCoordinate = xCord;
        this.yCoordinate = yCord;
        this.slot = slot;
        this.sprite = new Sprite(red, green, blue, hLength, vLength);

    }

    public int getSlot() {
        return slot;
    }
}
