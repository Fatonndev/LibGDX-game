package com.kevitv.game.control;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.kevitv.game.content.Blocks;
import com.kevitv.game.view.MainScreen;

public class CameraControl implements InputProcessor {

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        float blockLength = 32 / MainScreen.camera.zoom / MainScreen.aspectRatio;
        float blockLength2 = 32;
        float x = (screenX / blockLength);
        float y = (MainScreen.HEIGHT-screenY)/blockLength;

        x+= (MainScreen.camera.position.x - MainScreen.HEIGHT/2 * MainScreen.camera.zoom) / blockLength2;
        y+= (MainScreen.camera.position.y - MainScreen.HEIGHT*MainScreen.aspectRatio/2 * MainScreen.camera.zoom) / blockLength2;

        int X = (int) x;
        int Y = (int) y;

        if (button == Input.Buttons.LEFT)
        if (MainScreen.world.sizeX > X && MainScreen.world.sizeY > Y && 0 <= X && 0 <= Y) {
            MainScreen.world.tile(X, Y).setBlock(Blocks.wall);
        }

        if (button == Input.Buttons.RIGHT)
        if (MainScreen.world.sizeX > X && MainScreen.world.sizeY > Y && 0 <= X && 0 <= Y) {
            MainScreen.world.tile(X, Y).setBlock(Blocks.air);
        }

        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        if (amount == 1) MainScreen.camera.zoom = MainScreen.camera.zoom+0.13f;
        else MainScreen.camera.zoom = MainScreen.camera.zoom-0.13f;
        MainScreen.camera.update();
        MainScreen.batch.setProjectionMatrix(MainScreen.camera.combined);
        return false;
    }
}
