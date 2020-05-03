package com.kevitv.game.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.kevitv.game.logic.Update;
import com.kevitv.game.utils.Assets;
import com.kevitv.game.utils.Log;

public class Block extends Update {

    public int size = 1;
    public int x = 0;
    public int y = 0;
    public String name = "null";
    public TextureRegion texture;
    public Polygon bounds;
    public Sprite object;

    public Block(String name, int x, int y) {
        this.name = name;
        this.x=x;
        this.y=y;
        load();
    }

    public Block(String name) {
        this.name = name;
        load();
    }

    public void load() {
        if(name.equals("air")) return;
        texture = Assets.getTexture(name);

        object = new Sprite(texture);
        object.setSize(32*size,32*size);
        object.setOrigin(32*size/2f, 32*size/2f);
        object.setPosition(32*x,32*y);

        bounds = new Polygon(new float[]{0f, 0f, 32f*size, 0f, 32f*size, 32f*size, 0f, 32f*size});
        bounds.setPosition(32*x, 32*y);
        bounds.setOrigin(32*size/2f, 64*size/2f);
    }


    @Override
    public void Draw(SpriteBatch batch) {

    }
}
