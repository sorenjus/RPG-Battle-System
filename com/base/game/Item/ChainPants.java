package com.base.game.Item;

public class ChainPants extends EquippableItems{

    public static final float SIZE = 32;
    public static final String ITEMNAME = "Chain Mail Pants";


    public ChainPants (float xCoord, float yCoord){

        init(xCoord, yCoord, 0.1f,0.5f,0.9f, SIZE, SIZE, LEG_SLOT);
        this.setItemName(ITEMNAME);
    }
}
