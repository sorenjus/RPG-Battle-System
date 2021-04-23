package com.base.game.Item;

import com.base.engine.GameObject;
import com.base.engine.Sprite;


/**
 *
 * @author  Adrian Croitoru
 *
 */
public class Item extends GameObject {


    protected String itemName;
    protected Sprite itemSprite;


    protected void init(final float xCord, final float yCord, final float red, final float green, final float blue, final float hLength, final float vLength) {
        this.xCoordinate = xCord;
        this.yCoordinate = yCord;
        typeOfItem= "Item";
        this.sprite = new Sprite(red, green, blue, hLength, vLength);
    }
       public String getItemName()
    {
        return itemName;
    }

    public void setItemName(String name){
        this.itemName= name;
    }
}
