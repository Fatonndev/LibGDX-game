package com.kevitv.game.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.kevitv.game.model.Block;
import com.kevitv.game.model.Shadow;
import com.kevitv.game.view.MainScreen;


public class Draw {

    public static void draw() {

        if(MainScreen.world == null) return;

        for(int xi = 0; xi < MainScreen.world.sizeX; xi++) {
            for(int yi = 0; yi < MainScreen.world.sizeY; yi++) {
                Sprite obj = MainScreen.world.tile(xi, yi).floor.object;
                obj.draw(MainScreen.batch);
            }
        }

        Shadow.draw();
        Block.draw();

    }
}
