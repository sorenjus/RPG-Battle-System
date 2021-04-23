package com.base.engine;

import static org.lwjgl.opengl.GL11.*;

/**
 * Class for all in-game objects with sprites
 *
 * @author Jason Truskowski
 */
public abstract class GameObject {
    /**
     * Coordinates of the GameObject on the overworld
     */
    protected transient float xCoordinate, yCoordinate;

    /**
     * The GameObject's sprite
     */
    protected transient Sprite sprite;

    /**
     * Whether the GameObject has been deleted
     */
    protected boolean delete = false;

    /**
     * The type of item (whether it can be picked up or not)
     */
    protected transient String typeOfItem="";

    /**
     * Updates the state of the GameObject
     */
    public void update() { }

    /**
     * Renders the sprites for GameObjects
     */
    public void render() {
        glPushMatrix();

        glTranslatef(xCoordinate, yCoordinate, 0);
        sprite.render();

        glPopMatrix();
    }

    /**
     * Getter method for the GameObject's x coordinate
     *
     * @return The x-coordinate position of the GameObject
     */
    public float getX() {
        return xCoordinate;
    }

    /**
     * Getter method for the GameObject's y coordinate
     *
     * @return The y-coordinate position of the GameObject
     */
    public float getY() {
        return yCoordinate;
    }

    /**
     * Getter method for the GameObject's width
     *
     * @return The width of the GameObject
     */
    public float getSizeX() {
        return sprite.getSizeX();
    }

    /**
     * Getter method for the GameObject's height
     *
     * @return The height of the GameObject
     */
    public float getSizeY() {
        return sprite.getSizeY();
    }

    /**
     * Setter method for the GameObject's width
     *
     * @param x The desired width of the GameObject
     */
    protected void setX(float x) {
        this.xCoordinate = x;
    }

    /**
     * Setter method for the GameObject's height
     *
     * @param y The desired height of the GameObject
     */
    protected void setY(float y) {
        this.yCoordinate = y;
    }

    /**
     * Returns the item type
     *
     * @return 0 for items that cannot be picked up, 1 for items that can
     */
    public String getTypeItem(){ return typeOfItem; }

    /**
     * Determines if the GameObject has been deleted
     *
     * @return Whether the GameObject is deleted
     */
    public boolean getDelete()
    {
        return delete;
    }

    /**
     * Deletes the GameObject
     */
    public void setDeleteTrue()
    {
        delete = true;
    }

    /**
     * Initializes information about the sprite
     *
     * @param xCord Horizontal position
     * @param yCord Vertical position
     * @param r Red value of sprite color
     * @param g Green value of sprite color
     * @param b Blue value of sprite color
     * @param hLength Horizontal length (width)
     * @param vLength Vertical length (height)
     * @param typeOfItem Whether the item is able to be picked up
     */
    protected void init(final float xCord, final float yCord, final float r, final float g, final float b,
                        final float hLength, final float vLength, final String typeOfItem) {
        this.xCoordinate = xCord;
        this.yCoordinate = yCord;
        this.typeOfItem = typeOfItem;
        this.sprite = new Sprite(r, g, b, hLength, vLength);
    }
}
