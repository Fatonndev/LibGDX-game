package com.kevitv.game.content;

import com.kevitv.game.model.Block;
import com.kevitv.game.model.Floor;

public class Blocks {

    public static Block
    air, grass, sand,
    wall, grassRock;

    public static void load() {
        air = new Floor("air"){{
        }};

        grass = new Floor("grass"){{
        }};

        sand = new Floor("sand"){{
        }};

        wall = new Block("wall"){{
        }};

        grassRock = new Block("grassRock"){{
        }};
    }

}
