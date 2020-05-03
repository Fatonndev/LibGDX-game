package com.kevitv.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.kevitv.game.logic.World;

public class MainScreen implements Screen {

    public static float deltaCff;
    public static SpriteBatch batch;
    public static TextureAtlas textureAtlas;
    public static World world = new World(10,10);

    public OrthographicCamera camera;

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        this.textureAtlas = textureAtlas;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        ScreenManager.setScreen(new MenuScreen());
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

        float aspectRatio = (float) height/width;
        camera = new OrthographicCamera(20f, 20f*aspectRatio);
        camera.zoom = 0.9f;
        camera.update();
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
    }
}
