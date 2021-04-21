package com.base.game.Item;


import com.base.game.gameobjects.PlayerCharacter;

public class Sword extends Item {

    public static final float SIZE = 32;
    private static final String ITEMNAME = "Sword";

    public Sword (float xCoord, float yCoord, PlayerCharacter player){
        super(player);
        init(xCoord, yCoord, .3f,.5f,.1f,SIZE,SIZE, 0 );
        setItemName(ITEMNAME);
    }


}
