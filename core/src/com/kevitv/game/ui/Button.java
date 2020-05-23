package com.kevitv.game.ui;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.kevitv.game.utils.Assets;
import com.kevitv.game.view.MainScreen;

public class Button {

    public static Sprite object = new Sprite(Assets.getTexture("player"));

    public static void initialize () {
    }

    public static void display (String text, float x, float y, float width, float height) {
        object.setSize(width, height);
        object.setOrigin(width/2, height/2);
        object.setPosition(x,y);
        object.draw(MainScreen.batch);
    }

}
