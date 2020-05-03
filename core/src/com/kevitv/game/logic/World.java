package com.kevitv.game.logic;

import com.kevitv.game.content.Blocks;

public class World {

    private Tile[][] tiles;

    public World(int x, int y) {

        tiles = new Tile[x][y];

        for(int xi = 0; xi < x; xi++) {
            for(int yi = 0; yi < y; yi++) {
                tiles[xi][yi] = new Tile(xi,yi);
                tiles[xi][yi].setXY(xi, yi);
            }
        }

        tile(2,2).setBlock(Blocks.wall);
    }

    public Tile tile(int x, int y) {
        return tiles[x][y];
    }

}
