package com.kevitv.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kevitv.game.ui.Button;
import com.kevitv.game.ui.TextManager;

public class MenuScreen extends Screen{

    @Override
    public void create() {

    }

    @Override
    public void show() {
        Button.initialize();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        TextManager.displayMessage("FPS: "+ Gdx.graphics.getFramesPerSecond(), true, false, false, true);
        Button.display("lol", 20, 20,100, 50);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
