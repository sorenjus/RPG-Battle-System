package com.base.game.item;
/**
 * Class for a Sword that can be equipped and used
 *
 * @author Adrian Croitoru
 */
public class Cap extends EquippableItems{
    /**
     * The size of the sword
     */
    public static final float SIZE = 32;
    /**
     * The name of the item
     */
    public static final String ITEMNAME = "Cap";
    /**
     * The increased damage the sword lets the player deal
     */
    private final int DEFENSE;

    /**
     * Constructor for a new Cap hat
     *
     * @param xCoord Horizontal position
     * @param yCoord Vertical position
     */
    public Cap (final float xCoord, final float yCoord){

        init(xCoord, yCoord, 0.1f,0.5f,0.9f, SIZE, SIZE, HEAD_SLOT);
        this.setItemName(ITEMNAME);
        this.DEFENSE=1;
    }

    /**
     * Getter method for the defense stat of the weapon
     * @return defense of the Item
     */
    public int getDefense() {
        return DEFENSE;
    }
}
