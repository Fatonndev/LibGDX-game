package com.kevitv.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.kevitv.game.content.Blocks;
import com.kevitv.game.utils.Assets;
import com.kevitv.game.view.MainScreen;

public class Main extends Game {

    private Screen gameScreen;

    public Assets assets;
    public static TextureAtlas textureAtlas;

    @Override
    public void create() {
        assets = new Assets();
        textureAtlas = assets.getManager().get("atlas1.atlas", TextureAtlas.class);
        Blocks.load();
        gameScreen = new MainScreen();
        ((MainScreen)gameScreen).setTextureAtlas(textureAtlas);
        setScreen(gameScreen);
    }

    @Override
    public void dispose() {
        super.dispose();
        gameScreen.dispose();
        assets.getManager().dispose();
    }
}
