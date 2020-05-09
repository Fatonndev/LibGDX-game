package com.kevitv.game.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.kevitv.game.utils.Assets;

public class Block implements Cloneable {

    public int size = 1;
    public int x = 0;
    public int y = 0;
    public String name = "null";
    public TextureRegion texture;
    public Polygon bounds;
    public Sprite object;
    public Sprite shadow;

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

    @Override
    public Block clone() throws CloneNotSupportedException {
        return (Block) super.clone();
    }

    public void load() {
        texture = Assets.getTexture(name);

        object = new Sprite(texture);
        object.setSize(32.04f*size,32.04f*size);
        object.setOrigin(32*size/2f, 32*size/2f);
        object.setPosition(32*x,32*y);

        shadow = new Sprite(Assets.getTexture("shadow"));
        shadow.setSize(32*size+4,32*size+4);
        shadow.setOrigin((32*size+4)/2f, (32*size+4)/2f);
        shadow.setPosition(32*x-2,32*y-2);

        bounds = new Polygon(new float[]{0f, 0f, 32f*size, 0f, 32f*size, 32f*size, 0f, 32f*size});
        bounds.setPosition(32*x, 32*y);
        bounds.setOrigin(32*size/2f, 64*size/2f);
    }

}
