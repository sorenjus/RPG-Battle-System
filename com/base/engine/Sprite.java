package com.base.engine;

import static org.lwjgl.opengl.GL11.*;

/**
 * This class handles the drawing and size of ingame sprites
 *
 * @author Jason Truskowski
 */
public class Sprite {

    /**
     * The color values for the sprite
     */
    private transient final float red, green, blue;

    /**
     * The horizontal and vertical size values for the sprite
     */
    private transient float sizex, sizey;

    /**
     * Default constructor for a sprite
     *
     * @param red     Red value
     * @param green   Green value
     * @param blue    Blue value
     * @param hLength Horizontal length
     * @param vLength Vertical height
     */
    public Sprite(final float red, final float green, final float blue, final float hLength, final float vLength) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.sizex = hLength;
        this.sizey = vLength;
    }

    /**
     * @return The (horizontal) length of the sprite
     */
    public float getSizeX() {
        return sizex;
    }

    /**
     * @return The (vertical) height of the sprite
     */
    public float getSizeY() {
        return sizey;
    }

    /**
     * @param spriteLength The desired sprite length
     */
    public void setSizeX(final float spriteLength) {
        this.sizex = spriteLength;
    }

    /**
     * @param spriteHeight The desired sprite height
     */
    public void setSizeY(final float spriteHeight) {
        this.sizey = spriteHeight;
    }

    /**
     * Draws the sprite
     */
    public void render() {
        glColor3f(red, green, blue);
        glBegin(GL_QUADS);

        // Drawing a simple rectangle as a placeholder
        // TODO: Implement actual sprites later
        glVertex2f(0, 0);
        glVertex2f(0, sizey);
        glVertex2f(sizex, sizey);
        glVertex2f(sizex, 0);

        glEnd();
    }
}
