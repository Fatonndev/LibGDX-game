package com.kevitv.game.content;

import com.kevitv.game.model.Block;
import com.kevitv.game.model.Floor;

public class Blocks {

    public static Block
    air, wall;

    public static void load() {
        air = new Floor("air"){{
        }};
        wall = new Block("wall"){{
        }};
    }

}
