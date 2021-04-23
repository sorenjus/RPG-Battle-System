package com.base.engine;

/**
 * Class allows for easier calling of tiles
 *
 * @author Ali Akid
 */
public enum TileType {

    grass("grass1", true), bricks("bricksx64", false);
    String textureName;
    boolean build;

    TileType(final String textureName, final boolean build) {
        this.textureName = textureName;
        this.build = build;
    }
}