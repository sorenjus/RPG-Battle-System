package com.base.engine;

import static Store.Tex.*;

/**
 * Populates the overworld with tiles
 */

public class TileGrid {

    /**
     * Creates a basic map matrix
     */
    public Tile[][] map;
    /**
     * constructor Loop that populates the world with Grass type tiles
     */
    public TileGrid() {
        map= new Tile[20][15];
        for (int i=0; i <map.length; i++) {
            for (int j=0; j<map[i].length;j++) {
                map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass);
            }
        }
    }

    /**
     * Loop to populate the world with Grass and Brick type tiles
     */
    public TileGrid(int[][] newMap) {
        map = new Tile[20][15];
        for (int i=0; i < map.length; i++) {
            for (int j=0; j < map[i].length;j++) {
                switch (newMap[j][i]) {
                    case 0:
                        map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass);
                        break;
                    case 1:
                        map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Bricks);
                        break;
                }
            }
        }
    }
    /**
     * Loop that assigns textures to tiles based on their type
     */
    public void Draw() {
        for (int i=0; i < map.length; i++) {
            for (int j=0; j < map[i].length;j++) {
                Tile t = map[i][j];
                DrawQuadTex(t.getTexture(),t.getX(),t.getY(),t.getWidth(),t.getHeight());
            }
        }
    }
}
