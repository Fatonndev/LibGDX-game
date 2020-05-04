package com.kevitv.game.content;

import com.kevitv.game.model.Block;
import com.kevitv.game.model.Floor;

public class Blocks {

    public static Block
    air, grass,
    wall, grassRock;

    public static void load() {
        air = new Floor("air"){{

        }};

        grass = new Floor("grass"){{

        }};

        wall = new Block("wall"){{

        }};

        grassRock = new Block("grassRock"){{

        }};
    }

}
