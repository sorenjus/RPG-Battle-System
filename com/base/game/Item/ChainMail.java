package com.base.game.Item;

public class ChainMail extends EquippableItems {

    /**
     * The size of the sword
     */
    public static final float SIZE = 32;
    /**
     * The name of the item
     */
    public static final String ITEMNAME = "Chain Mail";
    /**
     * The increased damage the sword lets the player deal
     */
    private final int DEFENSE;

    /**
     * Constructor for a new Chain Mail Armor piece
     *
     * @param xCoord Horizontal position
     * @param yCoord Vertical position
     */
    public ChainMail (float xCoord, float yCoord){

        init(xCoord, yCoord, 0.1f,0.5f,0.9f, SIZE, SIZE, ARMOR_SLOT);
        this.setItemName(ITEMNAME);
        this.DEFENSE=3;
    }


    /**
     * Getter method for the defense stat of the weapon
     * @return defense of the Item
     */
    public int getDefense() {
        return DEFENSE;
    }
}
