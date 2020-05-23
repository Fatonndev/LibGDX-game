package com.kevitv.game.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.kevitv.game.view.MainScreen;

public class Shadow {
    public synchronized static void draw() {
        for(int xi = 0; xi < MainScreen.world.sizeX; xi++) {
            for(int yi = 0; yi < MainScreen.world.sizeY; yi++)
                if(!MainScreen.world.tile(xi, yi).block.name.equals("air")) {
                    Sprite obj = MainScreen.world.tile(xi, yi).block.shadow;
                    if(obj != null) obj.draw(MainScreen.batch);
                }
        }
    }
}
