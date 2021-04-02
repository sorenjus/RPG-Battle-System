package com.base.engine;


/**
 * Class allows for easier calling of tiles
 */

public enum TileType {

    Grass("grass1",true), Bricks("bricksx64",false);
    String textureName;
    boolean build;
    TileType(String textureName, boolean build){
        this.textureName = textureName;
        this.build = build;
    }
}
