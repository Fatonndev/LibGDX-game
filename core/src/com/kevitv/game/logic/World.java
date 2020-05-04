package com.kevitv.game.logic;

public class World {

    private Tile[][] tiles;
    public int sizeX, sizeY;

    public World(int x, int y) {

        sizeX=x;
        sizeY=y;

        tiles = new Tile[x][y];

        for(int xi = 0; xi < x; xi++) {
            for(int yi = 0; yi < y; yi++) {
                tiles[xi][yi] = new Tile(xi,yi);
                tiles[xi][yi].setXY(xi, yi);
            }
        }


    }

    public Tile tile(int x, int y) {
        return tiles[x][y];
    }

}
