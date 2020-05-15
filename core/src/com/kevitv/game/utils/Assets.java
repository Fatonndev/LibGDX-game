package com.kevitv.game.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.kevitv.game.Main;

public class Assets {

    public static AssetManager manager;
    public static void check(TextureRegion textureRegion) {
        textureRegion.getU();
    }

    public static TextureRegion getTexture(String name) {
        TextureRegion textureRegion;
        try {
            check(Main.textureAtlas.findRegion(name));
            textureRegion = Main.textureAtlas.findRegion(name);
        } catch (NullPointerException a) {
            return Main.textureAtlas.findRegion("null");
        }
        return textureRegion;
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
