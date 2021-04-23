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
    private Animation animation;
    protected transient Sprite sprite;
    protected boolean delete = false;

    protected transient String typeOfItem="";


    public void update() {

    }

    /**
     * Renders the sprites for game objects
     */

    public void render() {
        glPushMatrix();

        glTranslatef(xCoordinate, yCoordinate, 0);
        sprite.render();

        glPopMatrix();
    }

    /**
     * Return the value of X
     *
     * @return float
     */
    public float getX() {
        return xCoordinate;
    }

    /**
     * Return the value of Y
     *
     * @return float
     */
    public float getY() {
        return yCoordinate;
    }

    /**
     * Return the size value of X
     *
     * @return float
     */
    public float getSizeX() {
        return sprite.getSizeX();
    }

    /**
     * Return the size value of Y
     *
     * @return float
     */
    public float getSizeY() {
        return sprite.getSizeY();
    }


    protected void setX(float x) {
        this.xCoordinate = x;
    }

    protected void setY(float y) {
        this.yCoordinate = y;
    }

    /**
     * Return the item type (0 for non pickable items and 1 for pickable items)
     *
     * @return int
     */
    public String getTypeItem(){ return typeOfItem; }

    /**
     * Return the size value of Y
     *
     * @return float
     */
    public boolean getDelete()
    {
        return delete;
    }

    public void setDeleteTrue()
    {
        delete = true;
    }

    /**
     * Initialize the sprite
     * @param typeOfItem  What the object is (item, player, enemy etc.)
     * @param xCord   default horizontal
     * @param yCord   default vertical location
     * @param red     Red value
     * @param green   Green value
     * @param blue    Blue value
     * @param hLength Horizontal length
     * @param vLength Vertical height
     */
    public void init(final float xCord, final float yCord, final float red, final float green, final float blue, final float hLength, final float vLength, final String typeOfItem) {
        this.xCoordinate = xCord;
        this.yCoordinate = yCord;
        this.typeOfItem = typeOfItem;
        this.sprite = new Sprite(red, green, blue, hLength, vLength);
    }
}
