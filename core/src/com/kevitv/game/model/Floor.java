package com.kevitv.game.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.kevitv.game.utils.Assets;

public class Floor extends Block {

    public Floor(String name) {
        super(name);
    }

    @Override
    public void load() {
        if (Math.random()>0.7f) {
            object = new Sprite(Assets.getTexture(name+"-1"));
        } else {
            object = new Sprite(Assets.getTexture(name));
        }

        object.setSize(32.05f*size,32.05f*size);
        object.setOrigin(32*size/2f, 32*size/2f);
        object.setPosition(32*x,32*y);

        if (Math.random()>0.6f) {
            object.rotate(90);
        }
        if (Math.random()>0.2f) {
            object.rotate(180);
        }
    }
}
