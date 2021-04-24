package com.base.game.item;

/**
 * A class representing chain mail pants which boost player stats
 *
 */
public class ChainPants extends EquippableItems {


    /**
     * The size of the chain pants
     */
    public static final float SIZE = 32;
    /**
     * The name of the item
     */
    public static final String ITEMNAME = "Chain Mail Pants";
    /**
     * The increased defense the chain pants incrases
     */
    private final int defense;


    /**
     * Constructor for a new pair of Chain Pants
     *
     * @param xCoord Horizontal position
     * @param yCoord Vertical position
     */
    public ChainPants(final float xCoord, final float yCoord){
        super();
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
