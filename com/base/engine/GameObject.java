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
    protected transient int typeItem;
    protected boolean delete = false;

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
    public int getTypeItem(){ return typeItem; }

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
     * @param type    is the type of item. 0 for non-pickable items
     * @param xCord   default horizontal
     * @param yCord   default vertical location
     * @param red     Red value
     * @param green   Green value
     * @param blue    Blue value
     * @param hLength Horizontal length
     * @param vLength Vertical height
     */
    public void init(final float xCord, final float yCord, final float red, final float green, final float blue, final float hLength, final float vLength, final int type) {
        this.xCoordinate = xCord;
        this.yCoordinate = yCord;
        this.typeItem = type;
        this.sprite = new Sprite(red, green, blue, hLength, vLength);
    }
}
