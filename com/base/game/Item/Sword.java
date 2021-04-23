package com.base.game.Item;


import com.base.engine.Sprite;

public class Sword extends EquippableItems {

    public static final float SIZE = 32;
    public static final String ITEMNAME = "Sword";
    private int damage;


    public Sword (float xCoord, float yCoord){

        init(xCoord, yCoord, 0.1f,0.5f,0.9f, SIZE, SIZE, WEAPON_SLOT);
        this.setItemName(ITEMNAME);
        damage = 3;
    }


}
