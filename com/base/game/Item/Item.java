package com.base.game.Item;

import com.base.engine.GameObject;
import com.base.engine.Sprite;

/**
 * Class for items that can be picked up
 *
 * @author  Adrian Croitoru
 */
public class Item extends GameObject {
    /**
     * The name of the item
     */
    protected String itemName;

    /**
     * Initializes a new item
     * @param xCord Horizontal position
     * @param yCord Vertical position
     * @param red Red value
     * @param green Green value
     * @param blue Blue value
     * @param hLength Horizontal length
     * @param vLength Vertical length
     */
    protected void init(final float xCord, final float yCord, final float red, final float green, final float blue,
                        final float hLength, final float vLength) {
        this.xCoordinate = xCord;
        this.yCoordinate = yCord;
        typeOfItem= "1";
        this.sprite = new Sprite(red, green, blue, hLength, vLength);
    }
       public String getItemName()
    {
        return itemName;
    }

    /**
     * Changes the name of an item
     *
     * @param name Desired new name
     */
    public void setItemName(final String name){
        this.itemName= name;
    }
}
