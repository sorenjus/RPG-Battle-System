package com.base.game.Item;

public class ChainMail extends EquippableItems {

    public static final float SIZE = 32;
    public static final String ITEMNAME = "Chain Mail";


    public ChainMail (float xCoord, float yCoord){

        init(xCoord, yCoord, 0.1f,0.5f,0.9f, SIZE, SIZE, ARMOR_SLOT);
        this.setItemName(ITEMNAME);
    }
}
