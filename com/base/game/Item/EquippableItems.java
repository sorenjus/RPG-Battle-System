package com.base.game.Item;

import com.base.engine.Sprite;

public class EquippableItems extends Item {

    private int slot;



    public void init(final float xCord, final float yCord, final float red, final float green, final float blue, final float hLength, final float vLength) {
        this.xCoordinate = xCord;
        this.yCoordinate = yCord;
        this.sprite = new Sprite(red, green, blue, hLength, vLength);
    }

}
