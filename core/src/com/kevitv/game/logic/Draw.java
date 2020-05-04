package com.kevitv.game.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.kevitv.game.view.MainScreen;


public class Draw {

    public static void draw() {

        for(int xi = 0; xi < MainScreen.world.sizeX; xi++) {
            for(int yi = 0; yi < MainScreen.world.sizeY; yi++) {

                Sprite obj = MainScreen.world.tile(xi, yi).block.object;
                obj.draw(MainScreen.batch);

            }
        }

    }
}
