package com.kevitv.game.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.kevitv.game.content.Blocks;
import com.kevitv.game.model.Player;
import com.kevitv.game.utils.Map;
import com.kevitv.game.view.MainScreen;

public class CameraControl implements InputProcessor {

    public static float cameraX, cameraY;

    public static void update() {

        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            cameraY += MainScreen.deltaCff * MainScreen.player.speed * 7;
            PlayerControl.W();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            cameraY -= MainScreen.deltaCff * MainScreen.player.speed * 7;
            PlayerControl.S();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            cameraX -= MainScreen.deltaCff * MainScreen.player.speed * 7;
            PlayerControl.A();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            cameraX += MainScreen.deltaCff * MainScreen.player.speed * 7;
            PlayerControl.D();
        }

        MainScreen.batch.setProjectionMatrix(MainScreen.camera.combined);
        MainScreen.camera.position.set(cameraX, cameraY, 0);
        MainScreen.camera.update();
    }

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
        float x = (screenX / blockLength);
        float y = (MainScreen.HEIGHT-screenY)/blockLength;

        x += (MainScreen.camera.position.x - MainScreen.HEIGHT/2 * MainScreen.camera.zoom) / 32;
        y += (MainScreen.camera.position.y - MainScreen.HEIGHT*MainScreen.aspectRatio/2 * MainScreen.camera.zoom) / 32;

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
        Map.save();
        if (amount == 1) {
            if(MainScreen.camera.zoom < 1.5f) MainScreen.camera.zoom = MainScreen.camera.zoom+0.13f;
        }
        else if(MainScreen.camera.zoom > 0.5f) MainScreen.camera.zoom = MainScreen.camera.zoom-0.13f;
        return false;
    }
}
