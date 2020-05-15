package com.kevitv.game.view;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.kevitv.game.control.CameraControl;
import com.kevitv.game.control.PlayerControl;
import com.kevitv.game.logic.World;
import com.kevitv.game.model.Player;
import com.kevitv.game.utils.Assets;
import com.kevitv.game.utils.Map;
import com.kevitv.game.utils.TextManager;

public class MainScreen implements Screen {

    public static float deltaCff;
    public static SpriteBatch batch;
    public static TextureAtlas textureAtlas;
    public static World world = Map.load();
    public static int WIDTH, HEIGHT;
    public static OrthographicCamera camera;
    public static float aspectRatio;
    public static Player player;

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        this.textureAtlas = textureAtlas;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        ScreenManager.setScreen(new GameScreen());
        player = new Player();
        Gdx.input.setInputProcessor(PlayerControl.cameraControl);
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(ScreenManager.getCurrentScreen()!=null)
            ScreenManager.getCurrentScreen().render(batch);

        deltaCff = delta;
    }

    @Override
    public void resize(int width, int height) {

        if(ScreenManager.getCurrentScreen()!=null)
            ScreenManager.getCurrentScreen().resize(width,height);

        aspectRatio = (float) height / width;
        camera = new OrthographicCamera(height, height*aspectRatio);
        camera.position.set(CameraControl.cameraX, CameraControl.cameraY, 0);
        camera.update();

        TextManager.initialize(width, height);

        WIDTH = width;
        HEIGHT = height;
    }

    @Override
    public void pause() {
        if(ScreenManager.getCurrentScreen()!=null)
            ScreenManager.getCurrentScreen().pause();
    }

    @Override
    public void resume() {
        if(ScreenManager.getCurrentScreen()!=null)
            ScreenManager.getCurrentScreen().resume();
    }

    @Override
    public void hide() {
        if(ScreenManager.getCurrentScreen()!=null)
            ScreenManager.getCurrentScreen().hide();
    }

    @Override
    public void dispose() {
        if (ScreenManager.getCurrentScreen()!=null)
            ScreenManager.getCurrentScreen().dispose();
        batch.dispose();
        Assets.dispose();
        TextManager.dispose();
    }
}
