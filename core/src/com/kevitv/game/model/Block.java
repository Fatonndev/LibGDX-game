package com.kevitv.game.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.kevitv.game.content.Blocks;
import com.kevitv.game.utils.Assets;

public class Block {

    public int size = 1;
    public String name;
    public TextureRegion textureRegion;

    public Block(String name) {
        this.name = name;
        textureRegion = Assets.getTexture(name);
    }

}
