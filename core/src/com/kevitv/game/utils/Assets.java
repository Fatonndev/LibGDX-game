package com.kevitv.game.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.kevitv.game.Main;

public class Assets {

    public static AssetManager manager;

    public static TextureRegion getTexture(String name) {
        return Main.textureAtlas.findRegion(name);
    }

    public Assets() {
        manager = new AssetManager();
        manager.load("atlas1.atlas", TextureAtlas.class);
        manager.finishLoading();
    }

    public static AssetManager getManager() {
        return manager;
    }

    public static void dispose() {
        manager.dispose();
    }

}
