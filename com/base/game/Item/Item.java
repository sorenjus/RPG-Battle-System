package com.base.game.Item;

import com.base.engine.GameObject;
import com.base.engine.Physics;
import com.base.engine.Sprite;
import com.base.game.gameobjects.PlayerCharacter;

/**
 *
 * @author  Adrian Croitoru
 *
 */
public class Item extends GameObject {

    protected PlayerCharacter player;
    protected String itemName;
    protected Sprite itemSprite;


    public Item (PlayerCharacter player)
    {
        this.player=player;
    }
    public void pickUpItem() {

        player.pickUpItem(this);
        setDeleteTrue();
        System.out.println("you picked up " + itemName + "!");

    }

    public String getItemName()
    {
        return itemName;
    }

    @Override
    public void update ()
    {
        if(Physics.areColliding(this, player) == player)
            pickUpItem();
    }

    public void setItemName(String name){
        this.itemName= name;
    }
}
