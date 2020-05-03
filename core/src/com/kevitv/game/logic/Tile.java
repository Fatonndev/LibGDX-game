package com.kevitv.game.logic;

import com.kevitv.game.content.Blocks;
import com.kevitv.game.model.Block;

public class Tile {

    public short x, y;
    public Block block = Blocks.air;

    public Tile(int x, int y) {
        this.x = (short)x;
        this.y = (short)y;
    }

    public Tile(int x, int y, Block floor, Block overlay, Block block) {
        this.x = (short)x;
        this.y = (short)y;
    }

}
