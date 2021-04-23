package com.base.game.Item;

public class Cap extends EquippableItems{
    public static final float SIZE = 32;
    public static final String ITEMNAME = "Cap";


    public Cap (float xCoord, float yCoord){

        init(xCoord, yCoord, 0.1f,0.5f,0.9f, SIZE, SIZE, HEAD_SLOT);
        this.setItemName(ITEMNAME);
    }
}
