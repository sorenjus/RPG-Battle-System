package com.base.engine;

import org.newdawn.slick.opengl.Texture;

public class Tile {

    private float x, y, width, height;
    private Texture texture;
    private TileType type;

    /**
     * Default constructor a tile
     *
     * @param x x cartesian position
     * @param y y cartesian position
     * @param width width of the tile
     * @param height Height of the tile
     * @param type tile type
     */
    public Tile(float x, float y, float width, float height, TileType type) {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.type=type;
        this.texture=Store.QuickLoad(type.textureName);
    }

    /**
     * Draws the texture of the tile at a ceratin position
     */
    public void Draw() {
        Store.DrawQuadTex(texture,x,y,width,height);
    }

    /**
     * Getter for x cartesian position
     * @return y cartesian position
     */
    public float getX() {
        return x;
    }

    /**
     * Setter for the x cartesian position
     * @param x is the new position x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Getter for y cartesian position
     * @return y cartesian position
     */
    public float getY() {
        return y;
    }

    /**
     * Setter for the y cartesian position
     * @param y is the new position y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Getter for the width
     * @return width of the tile
     */

    public float getWidth() {
        return width;
    }

    /**
     * Setter for the width of the tile
     * @param width is the new width of the tile
     */

    public void setWidth(float width) {
        this.width = width;
    }

    /**
     * Getter for the height
     * @return height of the tile
     */


    public float getHeight() {
        return height;
    }

    /**
     * Setter for the height of the tile
     * @param height is the new height of the tile
     */

    public void setHeight(float height) {
        this.height = height;
    }
    /**
     * Getter for texture of the tile
     * @return texture of the tile
     */

    public Texture getTexture() {
        return texture;
    }
    /**
     * Setter for the texture of the tile
     * @param texture is the new texture of the tile
     */
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    /**
     * Getter for the type of tile
     * @return type of the tile
     */

    public TileType getType() {
        return type;
    }

    /**
     * Setter for the type of the tile
     * @param type is the new type of tile
     */

    public void setType(TileType type) {
        this.type = type;
    }

}
