package com.kevitv.game.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.kevitv.game.utils.Assets;

public class Floor extends Block {

    public Floor(String name) {
        super(name);
    }

    @Override
    public void load() {
        super.load();
        if (Math.random()>0.9f) {
            object = new Sprite(Assets.getTexture("grass-1"));
            object.setSize(32*size,32*size);
            object.setOrigin(32*size/2f, 32*size/2f);
            object.setPosition(32*x,32*y);
        }
    }
}
