package com.kevitv.game.logic;

import com.kevitv.game.model.Block;

public class Tile {

    public short x, y;
    public Block block = new Block("wall");

    public Tile(int x, int y) {
        this.x = (short)x;
        this.y = (short)y;
    }

    public void setXY(int x, int y) {
        block.x=x;
        block.y=y;
        block.load();
    }

    public void setBlock(Block block) {
        this.block=block;
    }

    public Tile(int x, int y, Block block) {
        this.x = (short)x;
        this.y = (short)y;
        this.block = block;
    }

}
