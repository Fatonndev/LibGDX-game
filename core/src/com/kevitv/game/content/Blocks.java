package com.kevitv.game.content;

import com.kevitv.game.model.Block;
import com.kevitv.game.model.Floor;

public class Blocks {

    public static Block
            grass, sand,
            air, wall, grassRock;

    public static void load() {

        grass = new Floor("grass"){{
        }};

        sand = new Floor("sand"){{
        }};

        air = new Block("air"){{
        }};

        wall = new Block("wall"){{
        }};

        grassRock = new Block("grassRock"){{
        }};
    }

}
