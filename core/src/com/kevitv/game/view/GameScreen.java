package com.kevitv.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kevitv.game.control.CameraControl;
import com.kevitv.game.control.PlayerControl;
import com.kevitv.game.logic.Draw;
import com.kevitv.game.ui.TextManager;
import com.kevitv.game.ui.UI;

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
        TextManager.displayMessage("FPS: "+ Gdx.graphics.getFramesPerSecond(), true, false, false, false);
        PlayerControl.update();
        CameraControl.update();
        UI.drawCurrentBlock();
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
