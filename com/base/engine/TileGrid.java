package com.base.engine;

/**
 * Populates the overworld with tiles
 *
 * @author Ali Akid
 */

public class TileGrid {

    /**
     * Creates a basic map matrix
     */
    public transient Tile[][] map;

    /**
     * constructor Loop that populates the world with Grass type tiles
     */
    public TileGrid() {
        map = new Tile[20][15];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.grass);
            }
        }
    }

    /**
     * Loop to populate the world with Grass and Brick type tiles
     */
    public TileGrid(final int[][] newMap) {
        map = new Tile[20][15];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (newMap[j][i]) {
                    case 0:
                        map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.grass);
                        break;
                    case 1:
                        map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.bricks);
                        break;
                }
            }
        }
    }

    /**
     * Loop that assigns textures to tiles based on their type
     */
    public void draw() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                final Tile tile = map[i][j];
                Store.drawQuadTex(tile.getTexture(), tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight());//NOPMD
            }
        }
    }
}
