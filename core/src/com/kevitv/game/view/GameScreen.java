package com.kevitv.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kevitv.game.control.CameraControl;
import com.kevitv.game.control.PlayerControl;
import com.kevitv.game.logic.Draw;
import com.kevitv.game.utils.TextManager;

public class GameScreen extends Screen{

    @Override
    public void create() {
    }

    @Override
    public void show() {
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        Draw.draw();
        MainScreen.player.draw();
        TextManager.displayMessage("FPS: "+ Gdx.graphics.getFramesPerSecond());
        PlayerControl.update();
        CameraControl.update();
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
