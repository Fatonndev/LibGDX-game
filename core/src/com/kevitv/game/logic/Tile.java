package com.kevitv.game.logic;

import com.kevitv.game.model.Block;
import com.kevitv.game.model.Floor;

public class Tile {

    public short x, y;
    public Block block = new Block("air");
    public Floor floor = new Floor("grass");

    public Tile(int x, int y) {
        this.x = (short)x;
        this.y = (short)y;
    }

    public Tile(int x, int y, Block block) {
        this.x = (short)x;
        this.y = (short)y;
        this.block = block;
    }

    public Tile(int x, int y, Floor floor, Block block) {
        this.x = (short)x;
        this.y = (short)y;
        this.floor = floor;
        this.block = block;
    }

    public void setXY(int x, int y) {
        floor.x=x; floor.y=y;
        floor.load();
        block.x=x; block.y=y;
        block.load();
    }

    public void setBlock(Block block1) {
        try {
            this.block = block1.clone();
            this.block.x=x;
            this.block.y=y;
            block.load();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public void setFloor(Floor floor1) {
        try {
            this.floor = (Floor) floor1.clone();
            this.floor.x=x;
            this.floor.y=y;
            floor.load();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
