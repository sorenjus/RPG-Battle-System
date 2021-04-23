package com.base.game.Item;

/**
 * Class for a Sword that can be equipped and used
 *
 * @author Adrian Croitoru
 */
public class Sword extends EquippableItems {
    /**
     * The size of the sword
     */
    public static final float SIZE = 32;

    /**
     * The name of the item
     */
    public static final String ITEMNAME = "Sword";

    /**
     * The increased damage the sword lets the player deal
     */
    private int damage;

    /**
     * Constructor for a new Sword
     *
     * @param xCoord Horizontal position
     * @param yCoord Vertical position
     */
    public Sword (float xCoord, float yCoord){
        init(xCoord, yCoord, 0.1f,0.5f,0.9f, SIZE, SIZE, WEAPON_SLOT);
        this.setItemName(ITEMNAME);
        damage = 3;
    }
}