package com.base.engine;

import org.newdawn.slick.opengl.Texture;

/**
 * This class creates a tile based on the parameters  and draws it
 *
 * @author Ali Akid
 */
public class Tile {

    private transient float xCord, yCord, width, height;
    private Texture texture;
    private TileType type;

    /**
     * Default constructor a tile
     *
     * @param xCord  x cartesian position
     * @param yCord  y cartesian position
     * @param width  width of the tile
     * @param height Height of the tile
     * @param type   tile type
     */
    public Tile(final float xCord, final float yCord, final float width, final float height, final TileType type) {
        this.xCord = xCord;
        this.yCord = yCord;
        this.width = width;
        this.height = height;
        this.type = type;
        this.texture = Store.quickLoad(type.textureName);
    }

    /**
     * Draws the texture of the tile at a ceratin position
     */
    public void draw() {
        Store.drawQuadTex(texture, xCord, yCord, width, height);
    }

    /**
     * Getter for x cartesian position
     *
     * @return xCord cartesian position
     */
    public float getX() {
        return xCord;
    }

    /**
     * Setter for the x cartesian position
     *
     * @param newxCord is the new position x to set
     */
    public void setX(final float newxCord) {
        this.xCord = newxCord;
    }

    /**
     * Getter for y cartesian position
     *
     * @return yCord cartesian position
     */
    public float getY() {
        return yCord;
    }

    /**
     * Setter for the y cartesian position
     *
     * @param newyCord is the new position y to set
     */
    public void setY(final float newyCord) {
        this.yCord = newyCord;
    }

    /**
     * Getter for the width
     *
     * @return width of the tile
     */

    public float getWidth() {
        return width;
    }

    /**
     * Setter for the width of the tile
     *
     * @param width is the new width of the tile
     */

    public void setWidth(final float width) {
        this.width = width;
    }

    /**
     * Getter for the height
     *
     * @return height of the tile
     */


    public float getHeight() {
        return height;
    }

    /**
     * Setter for the height of the tile
     *
     * @param height is the new height of the tile
     */

    public void setHeight(final float height) {
        this.height = height;
    }

    /**
     * Getter for texture of the tile
     *
     * @return texture of the tile
     */

    public Texture getTexture() {
        return texture;
    }

    /**
     * Setter for the texture of the tile
     *
     * @param texture is the new texture of the tile
     */
    public void setTexture(final Texture texture) {
        this.texture = texture;
    }

    /**
     * Getter for the type of tile
     *
     * @return type of the tile
     */

    public TileType getType() {
        return type;
    }

    /**
     * Setter for the type of the tile
     *
     * @param type is the new type of tile
     */

    public void setType(final TileType type) {
        this.type = type;
    }

}
