package com.kevitv.game.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.kevitv.game.content.Blocks;
import com.kevitv.game.view.MainScreen;


public class Draw {

    public static void draw() {

        for(int xi = 0; xi < 10; xi++) {
            for(int yi = 0; yi < 10; yi++) {

                if (!MainScreen.world.tile(xi,yi).block.equals(Blocks.air)) {
                    Sprite obj = MainScreen.world.tile(xi, yi).block.object;
                    obj.draw(MainScreen.batch);
                }

            }
        }

    }
}
