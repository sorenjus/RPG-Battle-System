package com.base.game.Item;

/**
 * A class representing chain mail pants which boost player stats
 *
 */
public class ChainPants extends EquippableItems{


    /**
     * The size of the sword
     */
    public static final float SIZE = 32;
    /**
     * The name of the item
     */
    public static final String ITEMNAME = "Chain Mail Pants";
    /**
     * The increased damage the sword lets the player deal
     */
    private final int defense;


    /**
     * Constructor for a new pair of Chain Pants
     *
     * @param xCoord Horizontal position
     * @param yCoord Vertical position
     */
    public ChainPants (final float xCoord, final float yCoord){

        init(xCoord, yCoord, 0.1f,0.5f,0.9f, SIZE, SIZE, LEG_SLOT);
        this.setItemName(ITEMNAME);
        this.defense =2;
        this.typeOfItem="1";
    }

    /**
     * Getter method for the defense stat of the weapon
     * @return defense of the Item
     */
    public int getDefense() {
        return defense;
    }
}
