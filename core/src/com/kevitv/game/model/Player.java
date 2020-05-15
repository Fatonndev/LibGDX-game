package com.kevitv.game.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.kevitv.game.utils.Assets;
import com.kevitv.game.view.MainScreen;

public class Player {

    public static float x = 64, y = 64;
    public float speed = 30f;
    public float rotateSpeed = 180f;
    public float rotation = 180f;
    public Sprite object;

    TextureRegion texture = Assets.getTexture("player");

    public Player() {
        load();
    }

    public void load() {
        object = new Sprite(texture);
        object.setSize(64.04f,64f);
        object.setOrigin(64/2f, 64/2f);
    }

    public void draw() {
        object.setPosition(x-32, y-32);
        object.setRotation(-rotation-180f);
        object.draw(MainScreen.batch);
    }
}
