package com.kevitv.game.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kevitv.game.Main;
import com.kevitv.game.content.Blocks;
import com.kevitv.game.logic.Tile;
import com.kevitv.game.logic.World;
import com.kevitv.game.utils.Log;
import com.kevitv.game.view.MainScreen;

public class CameraControl implements InputProcessor {

    public void update() {
        MainScreen.batch.setProjectionMatrix(MainScreen.camera.combined);

        if(Gdx.input.isKeyPressed(Input.Keys.W))
            MainScreen.camera.position.set(MainScreen.camera.position.x, MainScreen.camera.position.y+2f, MainScreen.camera.position.z);
        if(Gdx.input.isKeyPressed(Input.Keys.S))
            MainScreen.camera.position.set(MainScreen.camera.position.x, MainScreen.camera.position.y-2f, MainScreen.camera.position.z);
        if(Gdx.input.isKeyPressed(Input.Keys.A))
            MainScreen.camera.position.set(MainScreen.camera.position.x-2f, MainScreen.camera.position.y, MainScreen.camera.position.z);
        if(Gdx.input.isKeyPressed(Input.Keys.D))
            MainScreen.camera.position.set(MainScreen.camera.position.x+2f, MainScreen.camera.position.y, MainScreen.camera.position.z);

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

        float blockLength = 56f / MainScreen.camera.zoom;
        float blockLength2 = 32;
        int x = (int) (screenX / blockLength);
        int y = (int) ((MainScreen.HEIGHT-screenY)/blockLength);

        int xx = (int) ((MainScreen.camera.position.x - MainScreen.HEIGHT/2 * MainScreen.camera.zoom) / blockLength2);
        x+=xx;
        int yy = (int) ((MainScreen.camera.position.y - MainScreen.HEIGHT*MainScreen.aspectRatio/2 * MainScreen.camera.zoom) / blockLength2);
        y+=yy;

        Log.info("MouseX: "+screenX+" XX: "+xx+" BlockLength2: "+32 / MainScreen.camera.zoom+" ZOOM: "+MainScreen.camera.zoom+" X: "+x);
        if (MainScreen.world.sizeX > x && MainScreen.world.sizeY > y && 0 <= x && 0 <= y) {
            MainScreen.world.tile(x, y).setBlock(Blocks.wall);
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
