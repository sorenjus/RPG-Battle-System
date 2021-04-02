package com.base.engine;

import org.newdawn.slick.opengl.Texture;

import static Store.Tex.*;
/**
 * Class to create overworld tiles
 */
public class Tile {

    private float x, y, width, height;
    private Texture texture;
    private TileType type;
    /**
     * Constructor for tiles
     * @param x is the cartesian position x on the overworld where the tile is created
     * @param y is the cartesian position y on the overworld where the tile is created
     * @param width is the width of the tile
     * @param height is the height of the tile
     * @param type Type of tile created
     */
    public Tile(float x, float y, float width, float height, TileType type) {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.type=type;
        this.texture=QuickLoad(type.textureName);
    }

    /**
     * Draws the tile physically on the overworld
     */
    public void Draw() {
        DrawQuadTex(texture,x,y,width,height);
    }

    /**
     * Getter for the x position of the tile on the overworld
     * @return x cartesian position x of the tile on the overworld
     */
    public float getX() {
        return x;
    }
    /**
     * Setter for the x position of the tile on the overworld
     * @param x cartesian position x of the tile on the overworld to be set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Getter for the y position of the tile on the overworld
     * @return y cartesian position y of the tile on the overworld
     */
    public float getY() {
        return y;
    }

    /**
     * Setter for the y position of the tile on the overworld
     * @param y cartesian position y of the tile on the overworld to be set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Getter for the width of the tile on the overworld
     * @return width returns the width of the tile
     */
    public float getWidth() {
        return width;
    }

    /**
     * Setter for the width of the tile on the overworld
     * @param width sets the width of the tile on the overworld
     */
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     * Getter for the height of the tile on the overworld
     * @return height returns the width of the tile
     */
    public float getHeight() {
        return height;
    }

    /**
     * Setter for the height of the tile on the overworld
     * @param height sets the height of the tile on the overworld
     */

    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Getter for the Texture of the tile on the overworld
     * @return texture returns the texture of the tile
     */
    public Texture getTexture() {
        return texture;
    }

    /**
     * Setter for texture of a tile
     * @param texture sets texture of a tile
     */

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
    /**
     * Getter for the type of tile
     * @return type returns the type of the tile
     */
    public TileType getType() {
        return type;
    }

    /**
     * Setter for the type of a tile
     * @param type sets/changes the type of a tile
     */

    public void setType(TileType type) {
        this.type = type;
    }

}
