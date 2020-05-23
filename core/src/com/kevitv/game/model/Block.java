package com.kevitv.game.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.kevitv.game.utils.Assets;
import com.kevitv.game.view.MainScreen;

public class Block implements Cloneable {

    public int size = 1;
    public int x = 0;
    public int y = 0;
    public String name = "null";
    public TextureRegion texture;
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
        if(name.equals("air")) return;
        texture = Assets.getTexture(name);

        object = new Sprite(texture);
        object.setSize(32.05f*size,32.05f*size);
        object.setOrigin(32*size/2f, 32*size/2f);
        object.setPosition(32*x,32*y);

        shadow = new Sprite(Assets.getTexture("shadow"));
        shadow.setSize(32*size+4,32*size+4);
        shadow.setOrigin((32*size+4)/2f, (32*size+4)/2f);
        shadow.setPosition(32*x-2,32*y-2);
    }

    public synchronized static void draw() {
        for(int xi = 0; xi < MainScreen.world.sizeX; xi++) {
            for(int yi = 0; yi < MainScreen.world.sizeY; yi++) {
                if(!MainScreen.world.tile(xi, yi).block.name.equals("air")) {
                    Sprite obj = MainScreen.world.tile(xi, yi).block.object;
                    obj.draw(MainScreen.batch);
                }
            }
        }
    }

}
